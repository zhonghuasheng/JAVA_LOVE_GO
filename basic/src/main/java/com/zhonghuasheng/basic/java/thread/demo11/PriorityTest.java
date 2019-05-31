package com.zhonghuasheng.basic.java.thread.demo11;

public class PriorityTest {

    public static void main(String[] args) {
        MyThread mt1 = new MyThread("mt1");
        MyThread mt2 = new MyThread("mt2");
        MyThread mt3 = new MyThread("mt3");
        MyThread mt4 = new MyThread("mt4");
        MyThread mt5 = new MyThread("mt5");
        mt1.setPriority(1);
        mt2.setPriority(1);
        mt3.setPriority(5);
        mt4.setPriority(10);
        mt5.setPriority(10);
        mt1.start();
        mt2.start();
        mt3.start();
        mt4.start();
        mt5.start();
    }

}
