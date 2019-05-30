package com.zhonghuasheng.basic.java.lang.thread.demo2;

public class MyRunnable implements Runnable {

    private int ticket = 10;

    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "sell ticket" + this.ticket--);
            }
        }
    }

}
