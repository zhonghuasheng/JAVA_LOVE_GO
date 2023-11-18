package com.zhonghuasheng.spring4.annotationinjectexample.resource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Application application = (Application) context.getBean("application");
        System.out.println(application);
    }
}
