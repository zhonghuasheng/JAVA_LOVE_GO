package com.zhonghuasheng.spring4.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(appContext.getEnvironment().getProperty("os.name"));
        CommandShow commandShow = appContext.getBean(CommandShow.class);
        commandShow.showListCmd();
    }
}
