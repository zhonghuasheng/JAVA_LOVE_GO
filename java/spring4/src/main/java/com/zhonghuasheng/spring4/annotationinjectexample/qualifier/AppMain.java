package com.zhonghuasheng.spring4.annotationinjectexample.qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Bond bond = (Bond) context.getBean("bond");
        bond.showCar();
    }
}
