package com.zhonghuasheng.basic.java.lang.thread.demo9;

public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.printf("[%s] \n", this.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("MyThread finished run");
    }
}
