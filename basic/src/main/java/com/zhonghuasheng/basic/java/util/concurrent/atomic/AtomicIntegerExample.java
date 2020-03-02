package com.zhonghuasheng.basic.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger ai = new AtomicInteger(0);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(ai.incrementAndGet());
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        System.out.println("Finally " + ai.get());
        /**
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         * 10
         * Finally 10
         */
    }
}
