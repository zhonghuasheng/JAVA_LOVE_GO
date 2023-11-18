package com.zhonghuasheng.basic.java.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Phone {

    private String name;

    public Phone() {}

    public Phone(String name) {
        this.name = name;
    }

    private Lock lock = new ReentrantLock();

    public synchronized void call() {
        //lock.lock();

        try {
            System.out.println(Thread.currentThread().getName() + " is running call method");
            //Thread.sleep(5000);
        } finally {
            System.out.println(Thread.currentThread().getName() + " finish running");
            //lock.unlock();
        }
    }

    public void message() {
        System.out.println(Thread.currentThread().getName() + " sending message");
    }

    public String getName() {
        return this.name;
    }
}
