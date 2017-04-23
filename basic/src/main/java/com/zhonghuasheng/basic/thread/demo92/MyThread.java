package com.zhonghuasheng.basic.thread.demo92;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(3);
                System.out.println(this.getName() + " isDaemon = " + isDaemon());
            }
        } catch (InterruptedException e) {
        }
    }
}
