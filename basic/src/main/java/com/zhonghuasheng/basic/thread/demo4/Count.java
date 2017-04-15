package com.zhonghuasheng.basic.thread.demo4;

public class Count {

    public void syncMethod() {
        /**
         * 同步代码块可以更精确的控制冲突限制访问区域
         */
        synchronized(this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " synchronized method " + i);
                }
            } catch(InterruptedException e) {
            }
        }
    }

    public void nonSyncMethod() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " noSynchronized method " + i);
            }
        } catch(InterruptedException e) {
        }
    }

    public synchronized void syncMethod2() {
        synchronized(this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " synchronized method " + i);
                }
            } catch(InterruptedException e) {
            }
        }
    }
}
