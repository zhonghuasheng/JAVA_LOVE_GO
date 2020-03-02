package com.zhonghuasheng.spring4.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AopConfig.class);
        UserService userService = appContext.getBean(UserService.class);
        NoAnnotationUserService noAnnotationUserService = appContext.getBean(NoAnnotationUserService.class);
        userService.register(new User("User1"));
        noAnnotationUserService.register(new User("User2"));
        appContext.close();
        /**
         * AnnotationPointCut执行之前
         * User{name='User1'}
         * AnnotationPointCut执行之后User注解式拦截register方法
         * 可以在这个方法执行之前做些什么register
         * 二月 21, 2020 6:32:01 下午 org.springframework.context.annotation.AnnotationConfigApplicationContext doClose
         * 信息: Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@1d56ce6a: startup date [Fri Feb 21 18:32:00 CST 2020]; root of context hierarchy
         * User{name='User2'}
         */
    }
}
