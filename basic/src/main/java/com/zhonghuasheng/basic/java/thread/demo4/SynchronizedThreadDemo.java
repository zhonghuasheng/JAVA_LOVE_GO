package com.zhonghuasheng.basic.java.thread.demo4;

public class SynchronizedThreadDemo {

    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        MyThread t3 = new MyThread("t3");
        MyThread t4 = new MyThread("t4");
        MyThread t5 = new MyThread("t5");
        MyThread t6 = new MyThread("t6");
        MyThread t7 = new MyThread("t7");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }
}
