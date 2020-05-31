package com.zhonghuasheng.springboot.controller;

import com.zhonghuasheng.springboot.service.ForwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HiController {

    @Autowired
    private ForwardService forwardService;

    @GetMapping
    public String index() {
        return "Hi, Welcome to SpringBoot RedisTemplate sample!";
    }

    @PostMapping("/forward/{id}")
    public void forward(@PathVariable("id") Long id) {
        forwardService.forward(id);
    }
}
