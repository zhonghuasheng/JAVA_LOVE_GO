package com.zhonghuasheng.basic.java.thread.synchronize;

public class SynchronizedLockExample {

    public static void main(String[] args) {
        SynchronizedLock x = new SynchronizedLock();
        // x.syncA()与x.syncB()
        new Thread(()-> {
            try {
                x.syncA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Threadx ").start();
        new Thread(()-> {
            try {
                x.syncB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thready ").start();
        /** 实例锁。不能同时访问
         * Threadx 0
         * Threadx 1
         * Threadx 2
         * Thready 0
         * Thready 1
         * Thready 2
         */

        // z1.syncA与z2.syncB
        SynchronizedLock z1 = new SynchronizedLock();
        SynchronizedLock z2 = new SynchronizedLock();
        new Thread(() -> {
            try {
                z1.syncA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Threadz1").start();
        new Thread(() -> {
            try {
                z2.syncB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Threadz2").start();
        /**可以同时访问。实例锁
         * Threadz10
         * Threadz20
         * Threadz11
         * Threadz21
         * Threadz12
         * Threadz22
         */

        // x.syncA()与y.syncA()
        SynchronizedLock y = new SynchronizedLock();
        SynchronizedLock y2 = new SynchronizedLock();
        new Thread(() -> {
            try {
                y.syncA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thready1").start();
        new Thread(() -> {
            try {
                y2.syncA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thready2").start();
        /**实例锁。可以同时访问，实例不是同一个对象锁
         * Thready10
         * Thready20
         * Thready21
         * Thready11
         * Thready22
         * Thready12
         */

        // x.syncC()与y.syncD()
        SynchronizedLock x1 = new SynchronizedLock();
        SynchronizedLock y3 = new SynchronizedLock();
        new Thread(()-> {
            try {
                x1.syncC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Threadx1 ").start();
        new Thread(()-> {
            try {
                y3.syncD();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thready3 ").start();

        /** 全局锁。不能同时访问，static synchronized修饰的方法是全局静态的，与实例无关
         * Threadx1 0
         * Threadx1 1
         * Threadx1 2
         * Thready3 0
         * Thready3 1
         * Thready3 2
         */

        // x.syncA与SynchronizedLock.syncD
        SynchronizedLock x3 = new SynchronizedLock();
        new Thread(()-> {
            try {
                x3.syncA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Theradx3").start();
        new Thread(() -> {
            try {
                SynchronizedLock.syncD();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Threadstatic ").start();

        /** 可以同时访问。x.syncA是实例锁，SynchronizedLock.syncD是全局锁
         * Theradx30
         * Threadstatic 0
         * Theradx31
         * Threadstatic 1
         * Theradx32
         * Threadstatic 2
         */
    }
}

class SynchronizedLock {

    public synchronized void syncA() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            Thread.sleep(1000);
        }
    }

    public synchronized void syncB() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            Thread.sleep(1000);
        }
    }

    public static synchronized void syncC() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            Thread.sleep(1000);
        }
    }

    public static synchronized void syncD() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + i);
            Thread.sleep(1000);
        }
    }
}
