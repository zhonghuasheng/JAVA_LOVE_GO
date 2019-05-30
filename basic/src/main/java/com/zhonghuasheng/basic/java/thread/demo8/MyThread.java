package com.zhonghuasheng.basic.java.lang.thread.demo8;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s [%d]:%d \n", this.getName(), this.getPriority(), i);

            if (i % 4 == 0) {
                Thread.yield();
            }
        }
    }
}
