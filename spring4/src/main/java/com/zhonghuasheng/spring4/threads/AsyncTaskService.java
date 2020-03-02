package com.zhonghuasheng.spring4.threads;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTaskService {

    /**
     * @Async注解在方法上表明该方法是异步执行，如果注解在类上，表明该类下的所有方法都是异步执行
     * @param i
     */
    @Async
    public void executeAsyncTask(int i) {
        System.out.println("Execute async task: " + i);
    }

    @Async
    public void executeAsyncAddTask(int i) {
        System.out.println(i + i);
    }
}
