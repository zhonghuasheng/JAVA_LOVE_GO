package com.zhonghuasheng.basic.java.thread.yield;

import java.util.concurrent.locks.LockSupport;

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
        /**
         * yeild会让出当前线程的执行权，但是不会释放锁
         */
    }
}

class Yeild {

    public void call() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            if(i % 4 == 0) {
                Thread.yield();
            }
        }
    }
}