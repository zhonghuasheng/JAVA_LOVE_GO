package com.zhonghuasheng.basic.thread.lock;

public class Main {

    public static void main(String[] args) {
        final Phone phone1 = new Phone();

        new Thread("Thread " + 1) {
            @Override
            public void run() {
                phone1.call();
            }
        }.start();

        new Thread("Thread " + 2) {
            @Override
            public void run() {
                phone1.message();
            }
        }.start();
    }

}
