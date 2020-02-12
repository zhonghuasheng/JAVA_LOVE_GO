package com.zhonghuasheng.basic.java.thread.synchronize;

public class NoSynchronizedMethodExample {

    public static void main(String[] args) {
        NoSynchronizedMethod noSynchronizedMethod = new NoSynchronizedMethod();
        new Thread(()-> {
            noSynchronizedMethod.synchronizedMethod();
        }, "synchronizedMethod ").start();
        new Thread(()-> {
            noSynchronizedMethod.noSynchronized();
        }, "noSynchronizedMethod").start();
        /**
         *synchronized基本原则第二条：
         * 当一个线程访问一个对象的synchronized方法或者synchronized代码块时，其他线程对该对象的
         * 非synchronized方法的访问将不会被阻塞。
         * synchronizedMethod 0
         * noSynchronizedMethod0
         * noSynchronizedMethod1
         * noSynchronizedMethod2
         * synchronizedMethod 1
         * synchronizedMethod 2
         */
    }
}

class NoSynchronizedMethod {

    public void noSynchronized() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

    public void synchronizedMethod() {
        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
