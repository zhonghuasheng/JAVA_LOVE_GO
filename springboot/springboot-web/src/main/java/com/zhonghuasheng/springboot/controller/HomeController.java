package com.zhonghuasheng.springboot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Hello, SpringBoot Web";
    }

    // localhost:8080/web/sayHi/tom
    @RequestMapping("/sayHi/{name}")
    public String sayHi(@PathVariable String name) {
        return "Hi, " + name;
    }

    // localhost:8080/web/sayHello?name=tom
    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return "Hello, " + name;
    }

    // POST请求，消息体为tom
    @PostMapping("/sayGood")
    public String sayGood(@RequestBody(required = false) String name) {
        return "你好, " + name;
    }
}
