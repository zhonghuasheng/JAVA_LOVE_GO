package com.zhonghuasheng.spring4.threads;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);;
        AsyncTaskService asyncTaskService = appContext.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncAddTask(i);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 如下代码并不能中断程序的运行
        /*AppConfig appConfig = appContext.getBean(AppConfig.class);
        ThreadPoolTaskExecutor threadPool = (ThreadPoolTaskExecutor) appConfig.getAsyncExecutor();
        threadPool.shutdown();*/
        appContext.close();
        /**执行的结果并不是同步执行，而是异步执行
         * Execute async task: 0
         * 4
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
         */
    }
}
