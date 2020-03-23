package com.zhonghuasheng.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

@Component
public class RedisInitConfig {

    @Autowired
    RedisConfig redisConfig;

    @Bean(value = "jedisPoolConfig")
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(redisConfig.getMaxTotal());
        config.setMaxIdle(redisConfig.getMaxIdle());
        config.setMinIdle(redisConfig.getMinIdle());
        config.setMaxWaitMillis(10000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        config.setTestWhileIdle(true);

        System.out.println("Init JedisPoolConfig finished");
        return config;
    }

    @Bean(value = "jedisSentinelPool")
    public JedisSentinelPool jedisSentinelPool(@Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig) {
        Set<String> nodeSet = new HashSet<>();
        String nodes = redisConfig.getNodes();
        String[] nodeArray = nodes.split(",");
        for (String node : nodeArray) {
            nodeSet.add(node);
        }
        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool(
                redisConfig.getMasterName(), nodeSet, jedisPoolConfig, redisConfig.getTimeout());

        System.out.println("Init JedisSentinelPool finished");
        return jedisSentinelPool;
    }
}
