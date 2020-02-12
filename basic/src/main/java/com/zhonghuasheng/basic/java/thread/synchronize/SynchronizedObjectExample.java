package com.zhonghuasheng.basic.java.thread.synchronize;

public class SynchronizedObjectExample {

    public static void main(String[] args) {
        /*Runnable runnable = new SynchronizedObject();
        Thread thread1 = new Thread(runnable, "thread1");
        Thread thread2 = new Thread(runnable, "thread2");
        thread1.start();
        thread2.start();*/
        /** synchronized基本原则第一条：
         * 当一个线程访问一个对象的synchronized方法或者synchronized代码块时，其他线程对该对象的
         * 该synchronized方法或者synchronized代码块的访问将被阻塞。
         * thread10
         * thread11
         * thread12
         * thread13
         * thread14
         * thread20
         * thread21
         * thread22
         * thread23
         * thread24
         */
        Runnable runnable1 = new SynchronizedObject();
        Runnable runnable2 = new SynchronizedObject();
        Thread thread3 = new Thread(runnable1, "thread3 ");
        Thread thread4 = new Thread(runnable2, "thread4 ");
        thread3.start();
        thread4.start();
        /** synchronized中锁的必须是同一个对象
         * thread4 0
         * thread3 0
         * thread3 1
         * thread4 1
         * thread3 2
         * thread4 2
         * thread3 3
         * thread4 3
         * thread3 4
         * thread4 4
         */
    }
}

class SynchronizedObject implements Runnable {
    @Override
    public void run() {
        // synchronized(this)中的this是指“当前的类对象”，即synchronized(this)所在的类对应的当前对象。它的作用是获取“当前对象的同步锁”。
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

class SynchronizedObject2 implements Runnable {
    @Override
    public void run() {
        // 锁的是这个类
        synchronized (SynchronizedObject2.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
