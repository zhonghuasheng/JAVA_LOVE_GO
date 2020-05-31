package com.zhonghuasheng.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HiController {

    @GetMapping
    public String index() {
        return "Hi, Welcome to SpringBoot RedisTemplate sample!";
    }
}
