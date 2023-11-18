package com.zhonghuasheng.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/get/{key}")
    public String get(@PathVariable("key") String key) {
        String val = stringRedisTemplate.opsForValue().get(key);
        return val;
    }
}
