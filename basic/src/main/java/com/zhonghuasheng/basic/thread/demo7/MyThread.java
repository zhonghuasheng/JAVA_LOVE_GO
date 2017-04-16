package com.zhonghuasheng.basic.thread.demo7;

public class MyThread extends Thread {

    private Object obj;

    public MyThread(String name, Object obj) {
        super(name);
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized(obj) {
            System.out.println(Thread.currentThread().getName() + " run");

            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
