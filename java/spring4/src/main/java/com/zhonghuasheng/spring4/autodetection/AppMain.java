package com.zhonghuasheng.spring4.autodetection;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhonghuasheng.spring4.autodetection.model.User;
import com.zhonghuasheng.spring4.autodetection.service.UserService;

public class AppMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.zhonghuasheng.spring4.autodetection");
        context.refresh();

        UserService userService = (UserService) context.getBean("userService");
        userService.add(new User(1, "Luke"));
        System.out.println(userService.getById(1));
    }
}
