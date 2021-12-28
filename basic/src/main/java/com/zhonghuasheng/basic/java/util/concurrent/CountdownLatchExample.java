package com.zhonghuasheng.basic.java.util.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * CountdownLatch和CycliBarrier都属于线程同步工具
 * CountdownLatch 顾名思义，可以当作一个计数器来使用，比如某线程需要等待其他线程执行过后才能继续执行
 */
public class CountdownLatchExample {

    public static void main(String[] args) {
        countdownLatchExample();
        cyclicBarrier();
    }

    public static void countdownLatchExample() {
        // 参数count – the number of times countDown must be invoked before threads can pass through await。
        // 在await之后，程序必须经过10次计数才能继续往下执行
        final CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 20; i++) {
            final int times = i;
            new Thread(()-> {
                try {
                    //System.out.println("子线程" + Thread.currentThread().getName() + "----正在路上");
                    Thread.sleep(100 * times);
                    System.out.println("子线程" + Thread.currentThread().getName() + "到公司了");
                    latch.countDown();
                    //System.out.println("子线程" + Thread.currentThread().getName() + "----开始工作");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("门卫等待员工上班满足10人才下班。。。");
        try {
            // 主线程阻塞等待计数器归零
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // CountdownLatch会阻塞主线程
        System.out.println("员工到了10人，门卫下班了");
    }

    public static void cyclicBarrier() {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println("得有10个人准备好了才开始");
        });
        for (int i = 0; i < 12; i++) {
            final int times = i;
            new Thread(() -> {
                try {
                    Thread.sleep(100 * times);
                    System.out.println("子线程" + Thread.currentThread().getName() + "准备好了");
                    cyclicBarrier.await();
                    // 所有子线程都会被阻塞，等到所有线程准备好了采取执行
                    System.out.println("子线程" + Thread.currentThread().getName() + "开始跑了");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        // CyclicBarrier不阻塞主线程
        System.out.println("主线程---");
    }
}
