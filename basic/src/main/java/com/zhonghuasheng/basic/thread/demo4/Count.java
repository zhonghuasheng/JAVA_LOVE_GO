package com.zhonghuasheng.basic.thread.demo4;

public class Count {

    public void syncMethod() {
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
}
