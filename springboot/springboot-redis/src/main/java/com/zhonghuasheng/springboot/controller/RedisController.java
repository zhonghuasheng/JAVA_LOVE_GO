package com.zhonghuasheng.springboot.controller;

import com.zhonghuasheng.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @PostMapping("/set/{key}/{value}")
    public String set(@PathVariable("key") String key, @PathVariable("value") String value) {
        boolean set = redisService.set(key, value);
        return "Set Finished";
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key) {
        return redisService.get(key);
    }

    @GetMapping("/")
    public String index() {
        return redisService.get("hello");
    }

}
