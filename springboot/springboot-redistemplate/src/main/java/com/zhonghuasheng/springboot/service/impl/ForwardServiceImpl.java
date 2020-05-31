package com.zhonghuasheng.springboot.service.impl;

import com.zhonghuasheng.springboot.service.ForwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class ForwardServiceImpl implements ForwardService {

    private static final String PREFIX="music:forward";

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public void forward(Long id) {
        if (stringRedisTemplate.hasKey(PREFIX)) {
            stringRedisTemplate.opsForValue().increment(PREFIX, 1);
            System.out.println("After incr, the value is: " + stringRedisTemplate.opsForValue().get(PREFIX));
        } else {
            setKey(PREFIX, "101");
        }
    }

    public synchronized void setKey(String key, String value) {
        if (!stringRedisTemplate.hasKey(PREFIX)) {
            stringRedisTemplate.opsForValue().setIfAbsent(key, value, 24, TimeUnit.HOURS);
        } else {
            stringRedisTemplate.opsForValue().increment(PREFIX, 1);
        }

        System.out.println("After execute setKey method, the value is: " + stringRedisTemplate.opsForValue().get(key));
    }
}
