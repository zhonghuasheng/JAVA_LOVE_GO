package com.zhonghuasheng.basic.java.util.concurrent;

public class VolatileAtomicExample {

    private static volatile int num = 0;
    public static volatile int aNum = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increasNum();
                        increasANum();
                    }
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println(num);
        System.out.println(aNum);
    }

    private static void increasNum() {
        num++;
    }

    private static synchronized void increasANum() {
        aNum++;
    }
}
