package com.zhonghuasheng.basic.java.lang.thread.demo8;

public class YeildTest {

    public static void main(String[] args) {
        MyThread mt1 = new MyThread("t1");
        MyThread mt2 = new MyThread("t2");
        mt1.start();
        mt2.start();
    }

}
