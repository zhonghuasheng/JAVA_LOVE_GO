package com.zhonghuasheng.basic.thread.demo3;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "is running");
    }
}
