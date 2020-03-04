package com.zhonghuasheng.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {

    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        return "Hello, Spring Security!";
    }
}
