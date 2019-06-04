package com.zhonghuasheng.spring4.autowiringusingxml.constructor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("autowiringusingxml-constructor.xml");
        Performer performer = (Performer) context.getBean("performer");
        System.out.println(performer);
    }

}
