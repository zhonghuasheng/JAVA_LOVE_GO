package com.zhonghuasheng.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置RedisTemplate的序列化
     * @param redisTemplate
     */
    public RedisRepository(RedisTemplate redisTemplate) {
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        redisTemplate.setHashValueSerializer(redisSerializer);
        this.redisTemplate = redisTemplate;
    }


    /**
     * 获取分布式锁
     * @param key 锁
     * @param requestId 锁标识
     * @param expireTime 过期时间（毫秒）
     * @return 加锁是否成功
     */
    public boolean lock(String key, String requestId, int expireTime) {
        if (null == key || null == requestId || expireTime < 0) {
            return false;
        }

        boolean locked = false;
        int tryCount = 3;
        while (!locked && tryCount > 0) {
            locked = redisTemplate.opsForValue().setIfAbsent(key, requestId, expireTime, TimeUnit.MICROSECONDS);
            tryCount--;

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                log.error("获取分布式锁失败, {}", e);
            }
        }

        return locked;
    }

    /*
     * @param key 锁
     * @param requestId 锁标识
     * @return 释放锁是否成功
     */
    public boolean unlockLua(String key, String requestId) {
        if (null == key || null == requestId) {
            return false;
        }

        DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
        // 用于解锁的lua脚本位置
        redisScript.setScriptText("if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end");
        redisScript.setResultType(Long.class);
        // 没有指定序列化方式，默认使用上面配置的
        Object result = redisTemplate.execute(redisScript, Arrays.asList(key), requestId);
        return result.equals(Long.valueOf(1));
    }
}
