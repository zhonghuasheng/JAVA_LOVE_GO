package com.zhonghuasheng.spring4.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class Application {

    public static void main(String[] args) {
        // 调用方式一。VM配置-Dspring.profiles.active=dev
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        appContext.getBean(DataSource.class);
        appContext.close();

        // 调用方式二。必须要先设置使用哪个环境dev/prod，否则在初始化bean的时候容器不知道选哪个
        /*AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        appContext.getEnvironment().setActiveProfiles("dev");
        appContext.scan("com.zhonghuasheng.spring4.profile");
        appContext.close();*/
    }
}
