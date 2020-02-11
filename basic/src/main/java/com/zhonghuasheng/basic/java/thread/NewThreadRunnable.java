package com.zhonghuasheng.basic.java.thread;

public class NewThreadRunnable {

    public static void main(String[] args) {
        new NewRunnable().run();
    }
}

class NewRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread running");
    }
}
