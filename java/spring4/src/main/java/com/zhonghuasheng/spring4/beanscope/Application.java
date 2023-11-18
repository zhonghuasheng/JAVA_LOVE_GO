package com.zhonghuasheng.spring4.beanscope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        /**
         * Scope描述的是Spring容器如何新建Bean的实例的。Spring的Scope有以下几种，通过@Scope注解来实现。
         * (1) Singleton：一个Spring容器中只有一个Bean的实例，此为Spring的默认配置，全容器共享一个实例。
         * (2) Prototype：每次调用新建一个Bean的实例。
         * (3) Request：Web项目中，给每一个http request新建一个bean实例。
         * (4) Session：Web项目中，给每一个http session新建一个bean实例。
         * (5) GlobalSession：这个只在portal应用中有用，给每一个global http session新建一个bean实例。
         * 另外，在Spring Batch中还有一个Scope是使用@StepScope。
         * 下面简单演示默认的singleton和prototype，分别从Spring容器中获得2次Bean，判断Bean的实例是否相等。
         */
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserSingleService userSingleService1 = appContext.getBean(UserSingleService.class);
        UserSingleService userSingleService2 = appContext.getBean(UserSingleService.class);
        UserPrototypeService userPrototypeService1 = appContext.getBean(UserPrototypeService.class);
        UserPrototypeService userPrototypeService2 = appContext.getBean(UserPrototypeService.class);
        System.out.println(userSingleService1 == userSingleService2); // true
        System.out.println(userPrototypeService1 == userPrototypeService2); // false

        appContext.close();
    }
}
