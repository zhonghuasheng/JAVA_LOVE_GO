package com.zhonghuasheng.basic.java.util.concurrent;

public class VolatileVisibility {

    // 共享变量flag，每个线程会各自拷贝一份到自己的工作内存中
    private static boolean flag = false;
    // volatile修饰的变量能够实现在各个线程中共享
    private static volatile boolean volatileFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread 1 running");
                while (!flag) {
                    // Nothing to do
                }
                System.out.println("Thread 1 running done");
            }
        }).start();

        Thread.sleep(2000);
        new Thread(new Runnable() {
            public void run() {
                prepareData();
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread 3 running");
                while(!volatileFlag) {
                    // Nothing to do
                }
                System.out.println("Thread 3 running done");
            }
        }).start();

        Thread.sleep(2000);
        new Thread(new Runnable() {
            public void run() {
                prepareVolatileData();
            }
        }).start();
    }

    private static void prepareVolatileData() {
        System.out.println("Begin to change volatileFlag to true");
        volatileFlag = true;
        System.out.println("Changed volatileFlag to true");
    }

    private static void prepareData() {
        System.out.println("Begin to change flag to true");
        flag = true;
        System.out.println("Changed flag to true");
    }
}
