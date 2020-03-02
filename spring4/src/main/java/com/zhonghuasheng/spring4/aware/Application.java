package com.zhonghuasheng.spring4.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        AwareService awareService = appContext.getBean(AwareService.class);
        awareService.print();
        appContext.close();
    }
}
