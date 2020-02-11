package com.zhonghuasheng.basic.java.thread;

public class NewThreadThread {

    public static void main(String[] args) {
        new NewThread().start();
    }
}

class NewThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread running");
    }
}
