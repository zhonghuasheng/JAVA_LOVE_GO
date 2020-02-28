package com.zhonghuasheng.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/advice")
public class AdviceController {

    // ControllerAdvice处理全局异常
    @RequestMapping(value = "/error")
    public String error() {
        throw new IllegalArgumentException("ControllerAdvice exception example");
    }
}
