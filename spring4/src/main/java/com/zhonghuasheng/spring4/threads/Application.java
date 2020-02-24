package com.zhonghuasheng.spring4.threads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);;
        AsyncTaskService asyncTaskService = appContext.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncAddTask(i);
        }
        /**执行的结果并不是同步执行，而是异步执行
         * Execute async task: 0
         * 0
         * Execute async task: 3
         * 6
         * Execute async task: 4
         * 8
         * Execute async task: 5
         * 10
         * Execute async task: 6
         * 12
         * Execute async task: 7
         * 14
         * Execute async task: 8
         * 16
         * Execute async task: 9
         * 18
         * Execute async task: 2
         * 4
         * 2
         * Execute async task: 1
         */
    }
}
