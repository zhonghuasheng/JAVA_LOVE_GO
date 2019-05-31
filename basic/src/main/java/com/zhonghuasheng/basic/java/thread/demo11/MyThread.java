package com.zhonghuasheng.basic.java.thread.demo11;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "][" + this.getPriority() + "][" + i + "]");
        }
    }
}
