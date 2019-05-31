package com.zhonghuasheng.basic.java.thread.demo7;

public class NotifyAllTest {

    private static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + " run");
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");
        MyThread t3 = new MyThread("t3");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " sleep 3 seconds");


        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " notifyAll()");
            obj.notifyAll();
        }
    }

    static class MyThread extends Thread {

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized(obj) {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait");
                    obj.wait();
                    System.out.println(Thread.currentThread().getName() + " continue");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
