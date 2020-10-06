package com.zhonghuasheng.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RedisRepository {

    private final String REDIS_LOCK = new StringBuilder()
            .append("if redis.call('get',KEYS[1]) == ARGV[1] then")
            .append("    return redis.call('del',KEYS[1]);")
            .append("else")
            .append("    return 0;")
            .append("end;")
            .toString();

    private final String REDUCE_STOCK = new StringBuilder()
            .append("if (redis.call('exists', KEYS[1]) == 1) then")
            .append("    local stock = tonumber(redis.call('get', KEYS[1]));")
            .append("    if (stock == -1) then")
            .append("        return -1;")
            .append("    end;")
            .append("    if (stock > 0) then")
            .append("        redis.call('incrby', KEYS[1], -1);")
            .append("        return stock;")
            .append("    end;")
            .append("    return 0;")
            .append("end;")
            .append("return -1;")
            .toString();

    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public RedissonClient getRedissonClient() {
        return Redisson.create();
    }

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
            try {
                locked = redisTemplate.opsForValue().setIfAbsent(key, requestId, expireTime, TimeUnit.MICROSECONDS);

                if (!locked) {
                    tryCount--;
                    Thread.sleep(300);
                }
            } catch (InterruptedException e) {
                log.error("获取分布式锁失败, {}", e);
            } catch (Exception e) {
                // 获取锁是容易发生SocketTimeoutException
                log.warn("获取锁超时, {}", e);
            }
        }

        return locked;
    }

    /**
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
        redisScript.setScriptText(REDIS_LOCK);
        redisScript.setResultType(Long.class);
        // 没有指定序列化方式，默认使用上面配置的
        Object result = redisTemplate.execute(redisScript, Arrays.asList(key), requestId);
        return result.equals(Long.valueOf(1));
    }

    /**
     * 通过key获取value
     * @param key
     * @return
     */
    public Object get(String key) {
        if (null == key) {
            return null;
        }

        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 减库存
     * @param key
     * @return 剩余库存数量，-1表示参数key为null
     */
    public int decrement(String key) {
        if (null == key) {
            return -1;
        }

        DefaultRedisScript<Integer> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptText(REDUCE_STOCK);
        redisScript.setResultType(Integer.class);
        Object result = redisTemplate.execute(redisScript, Arrays.asList(key),  "");
        return Integer.valueOf(String.valueOf(result));
    }
}
