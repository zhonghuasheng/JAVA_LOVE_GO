package com.zhonghuasheng.spring4.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 1. 使用@Service注解声明当前UseFunctionService 类是Spring容器管理的一个Bean。
 * 2. 使用@Autowired将FunctionService的实体Bean注入到UseFunctionService 中，
 * 让UseFunctionService具备FunctionService的功能，此处使用JSR-330的@Inject注解或者JSR-250的@Resource注解是等效的。
 */
@Service
public class UserFunctionService {

    @Autowired
    private FunctionService functionService;

    public void say(String str) {
        functionService.say(str);
    }
}
