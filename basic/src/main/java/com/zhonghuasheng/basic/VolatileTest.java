package com.zhonghuasheng.basic;


public class VolatileTest {

    private static volatile long num;

    public static void main(String[] args) {
        // 测试被volatile修饰的变量不具有线程安全性
        for (int i = 0; i < 2000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    add();
                }
            }).start();
        }
        System.out.println("final = " + num);
    }

    public static synchronized void add() {
        num++;
        System.out.println(num);
    }
}
