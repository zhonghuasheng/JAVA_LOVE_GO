package com.zhonghuasheng.basic.java.thread.interrupted;

public class InterruptWaitExample {

    public static void main(String[] args) {
        Thread thread = new InterruptWaitThread("WaitThread ");
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception WaitThread state " + thread.getState());
        }
        System.out.println("Begin to interrupt waitThread state " + thread.getState());
        thread.interrupt();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Exception2 WaitThread state " + thread.getState());
        }
        System.out.println("End interrupted waitThread state " + thread.getState());
        /** 注意异常中try的范围，另外wait的调用需要先锁定对象，否则会报异常
         * WaitThread RUNNABLE1
         * WaitThread RUNNABLE2
         * Begin to interrupt waitThread state TIMED_WAITING
         * InterruptedException: WaitThread RUNNABLE
         */
    }
}

class InterruptWaitThread extends Thread {

    public InterruptWaitThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized(this) {
            try {
                for (int i = 1; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + this.getState() + i);
                    if(i % 2 == 0) {
                        wait(10000);
                    }
                }
            } catch(InterruptedException e) {
                System.out.println("InterruptedException: " + Thread.currentThread().getName() + this.getState());
            }
        }
    }
}