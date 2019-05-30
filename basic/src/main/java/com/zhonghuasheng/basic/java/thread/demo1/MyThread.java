package com.zhonghuasheng.basic.java.lang.thread.demo1;

public class MyThread extends Thread {
    private int ticket = 10;

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (this.ticket > 0) {
                System.out.println(this.getName() + "sell ticket " + this.ticket--);
            }
        }
    }
}
