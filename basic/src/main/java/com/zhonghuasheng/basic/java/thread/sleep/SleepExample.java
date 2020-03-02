package com.zhonghuasheng.basic.java.thread.sleep;

public class SleepExample {
    public static void main(String[] args) {
        Sleep sleep = new Sleep();
        new Thread(sleep::call, "Thread1 ").start();
        new Thread(sleep::call, "Thread2 ").start();
        new Thread(sleep::call, "Thread3 ").start();
        /**
         *Thread.sleep会让当前线程休眠，但是不会释放锁
         */
    }
}

class Sleep {

    public synchronized void call() {
        synchronized(this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + i);
                if(i % 4 == 0) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
