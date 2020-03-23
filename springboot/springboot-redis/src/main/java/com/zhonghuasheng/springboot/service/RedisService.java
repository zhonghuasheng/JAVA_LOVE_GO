package com.zhonghuasheng.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

@Service
public class RedisService {

    @Autowired
    JedisSentinelPool jedisSentinelPool;

    public boolean set(String key, String value) {
        Jedis jedis = getJedis();
        jedis.set(key, value);
        return true;
    }

    private Jedis getJedis() {
        return jedisSentinelPool.getResource();
    }

    public String get(String key) {
        Jedis jedis = getJedis();
        return jedis.get(key);
    }
}
