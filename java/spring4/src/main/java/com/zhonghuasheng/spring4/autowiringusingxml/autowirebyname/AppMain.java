package com.zhonghuasheng.spring4.autowiringusingxml.autowirebyname;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("autowiringusingxml-autowirebyname.xml");
        Application application = (Application) context.getBean("application");
        System.out.println(application);
    }

}
