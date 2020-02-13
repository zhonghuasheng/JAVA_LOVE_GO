package com.zhonghuasheng.basic.java.thread.yield;

public class YieldExample {

    public static void main(String[] args) {
        Yeild yeild = new Yeild();
        new Thread(yeild::call, "yeild1 ").start();
        new Thread(yeild::call, "yeild2 ").start();
        new Thread(yeild::call, "yeild3 ").start();
        new Thread(yeild::call, "yeild4 ").start();
        new Thread(yeild::call, "yeild5 ").start();
        new Thread(yeild::call, "yeild6 ").start();
        new Thread(yeild::call, "yeild7 ").start();
        new Thread(yeild::call, "yeild8 ").start();
        new Thread(yeild::call, "yeild9 ").start();
        new Thread(yeild::call, "yeild0 ").start();
    }
}

class Yeild {

    public synchronized void call() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            if(i % 4 == 0) {
                Thread.yield();
            }
        }
    }
}