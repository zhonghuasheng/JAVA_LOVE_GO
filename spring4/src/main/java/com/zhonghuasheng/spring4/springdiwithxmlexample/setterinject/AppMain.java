package com.zhonghuasheng.spring4.springdiwithxmlexample.setterinject;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main( String[] args ) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("springdiwithxmlexample-setterinject-config.xml");
        Communication app = (Communication) context.getBean("communication");
        app.communicate();
    }
}
