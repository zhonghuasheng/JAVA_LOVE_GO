package com.zhonghuasheng.spring4.propertyvalueannotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zhonghuasheng.spring4.propertyvalueannotation.configuration.AppConfig;
import com.zhonghuasheng.spring4.propertyvalueannotation.configuration.JDBCConfig;

public class AppMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        JDBCConfig jdbcConfig = (JDBCConfig) context.getBean("jdbcConfig");
        System.out.println(jdbcConfig.toString());
    }

}
