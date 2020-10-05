package com.zhonghuasheng.redis.controller;

import com.zhonghuasheng.redis.config.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private RedisRepository redisRepository;

    @GetMapping("/index/{requestId}")
    public String index(@PathVariable("requestId") String requestId) {
        Object value = redisRepository.unlockLua("redis-lock-key", requestId);
        return String.valueOf(value);
    }
}
