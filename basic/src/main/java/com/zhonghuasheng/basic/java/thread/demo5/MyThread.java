package com.zhonghuasheng.basic.java.thread.demo5;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    public void run() {
        synchronized(this) {
            System.out.println(Thread.currentThread().getName() + " call notify ");
            notify();
        }
    }
}
