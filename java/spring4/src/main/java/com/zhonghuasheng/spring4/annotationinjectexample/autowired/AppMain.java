package com.zhonghuasheng.spring4.annotationinjectexample.autowired;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Driver driver = (Driver) context.getBean("driver");
        System.out.println(driver);
    }
}
