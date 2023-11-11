package com.zhonghuasheng.springboot.controller;

import com.zhonghuasheng.springboot.exception.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestExceptionController {

    // 该异常会被CustomExceptionHandler接收，这是属于Controller内部的异常
    @GetMapping("/exception")
    public String exception() {
        int i = 1 / 0;

        return "failed";
    }

    @GetMapping("/myException")
    public String myException() {
        throw new MyException("My Exception");
    }
}
