package com.zhonghuasheng.basic.java.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NewThreadExecutorService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Future task = pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Test1");
            }
        });
        // 任务执行完后返回null，最后也会打印个null
        System.out.println(task.get());
    }
}
