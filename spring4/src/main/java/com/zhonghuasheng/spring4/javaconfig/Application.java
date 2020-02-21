package com.zhonghuasheng.spring4.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserFunctionService userFunctionService = appContext.getBean(UserFunctionService.class);
        userFunctionService.say("Java Config");
        appContext.close();
    }
}
