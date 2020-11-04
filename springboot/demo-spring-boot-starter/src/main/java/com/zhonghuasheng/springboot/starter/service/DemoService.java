package com.zhonghuasheng.springboot.starter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public class DemoService {

    private String userName;
    private Integer age;

    public DemoService(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public String say() {
        return this.userName + "! " + this.age;
    }
}
