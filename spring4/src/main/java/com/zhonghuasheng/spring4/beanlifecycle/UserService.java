package com.zhonghuasheng.spring4.beanlifecycle;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class UserService {

    @PostConstruct
    public void init() {
        System.out.println("UserService init method");
    }

    public UserService() {
        System.out.println("UserService Constructor");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserService destroy method");
    }
}
