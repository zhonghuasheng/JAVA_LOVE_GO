package com.zhonghuasheng.basic.java.util.concurrent.threadpool;

public class FixedThreadPoolMain {

    public static void main(String[] args) {
        FixedThreadPool fixedThreadPool = new FixedThreadPool(6, 3);
        for (int i = 0; i < 6; i++) {
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("put one thread into capacity");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        System.out.println("one thread has been notify");
                    }
                }
            });
        }
    }
}
