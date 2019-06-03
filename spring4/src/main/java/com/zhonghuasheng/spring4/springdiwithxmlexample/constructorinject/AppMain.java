package com.zhonghuasheng.spring4.springdiwithxmlexample.constructorinject;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

    // http://websystique.com/spring/spring-dependency-injection-example-with-constructor-and-property-setter-xml-example/
    public static void main(String[] args) {
        AbstractXmlApplicationContext context = new ClassPathXmlApplicationContext("springdiwithxmlexample-constructorinject-config.xml");
        Communication communication = (Communication) context.getBean("communication");
        communication.communicated();
    }
}
