package com.zhonghuasheng.spring4.javaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        /**
         * 与di不同，FunctionService和UserFunctionService都没有使用注解，在JavaConfig中通过@Configuration
         * 注解来说明这是一个配置类，@Bean注解在方法上，声明当前方法的返回值是一个bean
         */
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserFunctionService userFunctionService = appContext.getBean(UserFunctionService.class);
        userFunctionService.say("Java Config");
        appContext.close();
    }
}
