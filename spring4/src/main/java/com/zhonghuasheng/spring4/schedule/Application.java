package com.zhonghuasheng.spring4.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        while(true) {}
        /**
         * FixedRate: 15:29:49
         * FixedDelay: 15:29:49
         * Cron: 15:29:51
         * FixedDelay: 15:29:51
         * FixedDelay: 15:29:53
         * Cron: 15:29:54
         * FixedRate: 15:29:54
         * FixedDelay: 15:29:55
         * Cron: 15:29:57
         * FixedDelay: 15:29:57
         * FixedRate: 15:29:59
         * FixedDelay: 15:29:59
         */
    }
}
