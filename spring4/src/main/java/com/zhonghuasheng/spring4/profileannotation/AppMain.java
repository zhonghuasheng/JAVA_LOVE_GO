package com.zhonghuasheng.spring4.profileannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.scan("com.zhonghuasheng.spring4.profileannotation");
        context.refresh();
        context.close();
    }

}
