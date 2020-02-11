package com.zhonghuasheng.basic.java.thread;

public class NewThreadRunnable {

    public static void main(String[] args) {
        // run方法运行
        new NewRunnable().run();

        // start方法运行
        NewRunnable newRunnable = new NewRunnable();
        Thread thread = new Thread(newRunnable);
        thread.start();
    }
}

class NewRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread running");
    }
}
