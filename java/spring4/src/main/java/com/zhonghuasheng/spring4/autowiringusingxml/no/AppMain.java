package com.zhonghuasheng.spring4.autowiringusingxml.no;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("autowiringusingxml-no.xml");
        Driver driver = (Driver) context.getBean("driver");
        System.out.println(driver);
    }

}
