package com.zhonghuasheng.basic.java.thread.products.single;

public class Product {

    private int size;
    private final int capactiy = 100;

    public synchronized void product(int n) {
        while(size >= capactiy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        size+=n;
        System.out.println(Thread.currentThread().getName() + "生产" + n  + "个，剩余" + size);
        notifyAll();
    }

    public synchronized void consume(int n) {
        while ((size - n) < 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        size-=n;
        System.out.println(Thread.currentThread().getName() + "消费" + n  + "个，剩余" + size);
        notifyAll();
    }
}
