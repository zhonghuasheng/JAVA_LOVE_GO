package com.zhonghuasheng.basic.thread.demo4;

public class SynchronizedRunnableDemo {

    public static void main(String[] args) {
        Runnable demo = new MyRunnable();

        Thread t1 = new Thread(demo, "t1");
        Thread t2 = new Thread(demo, "t2");
        t1.start();
        t2.start();
    }

}
