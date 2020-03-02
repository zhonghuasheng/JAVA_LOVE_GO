package com.zhonghuasheng.spring4.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        /**
         * 1. 自定义事件，继承ApplicationEvent
         * 2. 定义事件监听器，实现ApplicationListener
         */
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        LogEventPublisher logEventPublisher = appContext.getBean(LogEventPublisher.class);
        logEventPublisher.publishLogEvent("test");
        appContext.close();
        /**
         * LogEventListener handle this event:test
         * TrackingLogListener handle this event: test
         */
    }
}
