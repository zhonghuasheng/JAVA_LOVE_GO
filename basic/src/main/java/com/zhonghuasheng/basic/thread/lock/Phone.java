package com.zhonghuasheng.basic.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Phone {

    private Lock lock = new ReentrantLock();

    public void call() {
        lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " is running call method");
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " finish running");
            lock.unlock();
        }
    }

    public void message() {
        System.out.println(Thread.currentThread().getName() + " sending message");
    }
}
