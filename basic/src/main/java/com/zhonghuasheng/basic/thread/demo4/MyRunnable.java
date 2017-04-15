package com.zhonghuasheng.basic.thread.demo4;

public class MyRunnable extends Thread {

    @Override
    public void run() {
        synchronized(this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loog " + i);
                }
            } catch(InterruptedException e) {
            }
        }
    }
}
