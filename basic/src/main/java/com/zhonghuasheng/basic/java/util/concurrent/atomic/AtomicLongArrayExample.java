package com.zhonghuasheng.basic.java.util.concurrent.atomic;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicLongArrayExample {

    public static void main(String[] args) throws InterruptedException {
/*        AtomicLongArray ala = new AtomicLongArray(10);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(()-> {
                for (int j = 0; j < 10; j++) {
                    // System.out.println(ala.incrementAndGet(j));
                    ala.incrementAndGet(j);
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            threads[i].join();
        }

        System.out.println("Print......");
        for (int i = 0; i < 10; i++) {
            System.out.println(ala.get(i));
        }*/

        long[] longs = new long[10];
        Thread[] threads1 = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads1[i] = new Thread(()-> {
                for (int j = 0; j < 100; j++) {
                    longs[0] = j;
                }
            });
        }
        for (int i = 0; i < threads1.length; i++) {
            threads1[i].start();
        }
    }
}
