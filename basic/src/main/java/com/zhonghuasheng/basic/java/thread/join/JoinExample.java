package com.zhonghuasheng.basic.java.thread.join;

public class JoinExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(i);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(i);
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(i);
                }
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("Finished");
        /**
         * When we call this method using a thread object, it suspends the execution of the calling thread until
         * the object called finishes its execution.
         * 当我们调用某个线程的这个方法时，这个方法会挂起调用线程，直到被调用线程结束执行，调用线程才会继续执行。
         * main线程是主线程，在main线程中启动了3个子线程，这三个子线程分别启动，然后分别调用join方法，主线程停止运行，
         * 当这3个子线程运行完后，主线程继续运行，主线程是在“等待”子线程执行完毕。
         * 不加join
         * Finished
         * 0
         * 1
         * 2
         * 0
         * 1
         * 2
         * 0
         * 1
         * 2
         * 加join后
         * 0
         * 1
         * 2
         * 0
         * 1
         * 2
         * 0
         * 1
         * 2
         * Finished
         */

    }
}
