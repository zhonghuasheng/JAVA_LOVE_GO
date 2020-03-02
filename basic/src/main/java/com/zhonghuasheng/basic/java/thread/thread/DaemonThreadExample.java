package com.zhonghuasheng.basic.java.thread.thread;

public class DaemonThreadExample {

    public static void main(String[] args) {
        System.out.println("main thread begin");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 这是一个死循环，测试的是当用户线程结束后，守护线程也会被JVM回收掉
                while(true) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }, "Deamon Thread");
        thread1.setDaemon(true);
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 200; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        }, "User Thread");
        // 添加钩子线程来查看JVM的退出
        Runtime.getRuntime().addShutdownHook(new Thread(()-> {
            System.out.println("JVM existed");
        }));
        thread1.start();
        thread2.start();
        System.out.println("main thread end");
    }
}
