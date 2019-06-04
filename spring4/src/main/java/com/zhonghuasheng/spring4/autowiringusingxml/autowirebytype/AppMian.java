package com.zhonghuasheng.spring4.autowiringusingxml.autowirebytype;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMian {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("autowiringusingxml-autowirebytype.xml");
        Employee employee = (Employee) context.getBean("employee");
        System.out.println(employee);
    }
}
