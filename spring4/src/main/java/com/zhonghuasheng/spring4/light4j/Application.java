package com.zhonghuasheng.spring4.light4j;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = appContext.getBean(UserService.class);
        userService.add();
        appContext.close();
    }
}
