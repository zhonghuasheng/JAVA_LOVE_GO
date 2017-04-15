package com.zhonghuasheng.basic.thread.demo4;

public class MyRunnable implements Runnable {

    public void run() {
        /**
         * 当一个线程访问“某对象”的synchronized代码块时，其他线程对“该对象”的该“synchronized方法”或者
         * “synchronized代码块”的访问将被阻塞。
         */
        synchronized(this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " loog " + i);
                }
            } catch(InterruptedException e) {
            }
        }
    }
}
