package com.zhonghuasheng.basic.java.thread.demo12;

public class DaemonTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is deamon = " + Thread.currentThread().isDaemon());

        MyThread mt1 = new MyThread("mt1");
        MyThread mt2 = new MyThread("mt2");
        mt2.setDaemon(true);
        mt1.start();
        mt2.start();
    }

}
