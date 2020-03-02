package com.zhonghuasheng.spring4.beanlifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        /**
         * 在我们进行实际开发的时候，经常遇到在Bean之前使用之前或者之后做些必要的操作，
         * Spring对Bean的生命周期的操作提供了支持。在使用Java配置和注解配置下提供如下两种方式：
         *
         * 1. Java配置方式：使用@Bean的initMethod和destroyMethod(相当于xml配置的init-method和destory-method)。
         * 2. 注解方式：利用JSR-250的@PostConstruct和@PreDestroy
         */
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = appContext.getBean(UserService.class);
        appContext.close();
        /**
         * UserService Constructor
         * UserService init method
         * BeanWayUserService Constructor
         * BeanWayUserService init method
         * BeanWayUserService destroy
         * UserService destroy method
         */
    }
}
