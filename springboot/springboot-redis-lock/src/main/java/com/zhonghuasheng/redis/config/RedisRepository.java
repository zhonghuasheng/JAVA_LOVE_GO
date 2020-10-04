package com.zhonghuasheng.redis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Component
public class RedisRepository {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 加锁，自旋重试三次
     *
     * @return
     */
    public boolean lock(String key, String requestId) {
        boolean locked = false;
        int tryCount = 3;
        while (!locked && tryCount > 0) {
            locked = redisTemplate.opsForValue().setIfAbsent(key, requestId, 2, TimeUnit.MINUTES);
            tryCount--;
        }
        return locked;
    }


    /**
     * 使用lua脚本解锁，不会解除别人锁
     *
     * @return
     */
    public boolean unlockLua(String key, String requestId) {

        DefaultRedisScript<Long> redisScript = new DefaultRedisScript();
        //用于解锁的lua脚本位置
        redisScript.setScriptText("if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end");
        redisScript.setResultType(Long.class);
        //没有指定序列化方式，默认使用上面配置的
        Object result = redisTemplate.execute(redisScript, Arrays.asList(key), requestId);
        return result.equals(Long.valueOf(1));
    }
}
