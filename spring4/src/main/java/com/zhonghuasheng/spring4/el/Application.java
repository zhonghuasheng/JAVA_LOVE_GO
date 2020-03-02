package com.zhonghuasheng.spring4.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UseResourceService useResourceService = appContext.getBean(UseResourceService.class);
        useResourceService.printResource();
    }
}
