package com.zhonghuasheng.basic.java.thread.waitnotify;

public class NotifyExample {

    public static void main(String[] args) {
        Notify notify = new Notify();
        new Thread(()-> {
            synchronized (notify) {
                while (notify.flag) {
                    System.out.println("User A");
                    try {
                        notify.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            notify.call();
            synchronized (notify) {
                notify.notifyAll();
            }
        }, "User A").start();

        new Thread(()-> {
            synchronized (notify) {
                while (notify.flag) {
                    System.out.println("User B");
                    try {
                        notify.wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            notify.call();
            synchronized (notify) {
                notify.notifyAll();
            }
        }, "User B").start();
        /**
         * Begin to call
         * User A calling 0%
         * User B
         * User A calling 50%
         * User A calling 100%
         * End to call
         * Begin to call
         * User B calling 0%
         * User B calling 50%
         * User B calling 100%
         * End to call
         */
    }
}

class Notify {
    public boolean flag = false;
    public void call() {
        flag = true;
        System.out.println(Thread.currentThread().getName() + " Begin to call");
        for (int i = 0; i < 101; i+=50) {
            System.out.println(Thread.currentThread().getName() + " calling " + i + "%");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " End to call");
        flag = false;
    }
}
