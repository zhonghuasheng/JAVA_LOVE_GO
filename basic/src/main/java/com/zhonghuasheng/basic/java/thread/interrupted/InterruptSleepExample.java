package com.zhonghuasheng.basic.java.thread.interrupted;

public class InterruptSleepExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new InterruptSleepThread("thread1 ");
        thread.start();
        Thread.sleep(200);
        thread.interrupt();
        System.out.println(thread.getName() + thread.getState() + " interrupted");
        Thread.sleep(200);
        System.out.println(thread.getName() + thread.getState() + " end");
        /** interrupt中断处于阻塞的线程
         * thread1 RUNNABLE
         * thread1 RUNNABLE
         * thread1 TIMED_WAITING interrupted
         * thread1 TERMINATED end
         */
    }
}

class InterruptSleepThread extends Thread {

    public InterruptSleepThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + this.getState());
                Thread.sleep(100);
            }
        } catch(InterruptedException ex) {
            System.out.println(Thread.currentThread().getName() + this.getState());
        }
    }
}