package com.zhonghuasheng.basic.thread.products;

public class Depot {

    // 仓库容量
    private int capacity;
    // 仓库中产品的实际数量
    private int size;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public synchronized void produce(int val) {
        System.out.printf("Current capacity %s size %s Thread %s \n", capacity, size, Thread.currentThread().getName());
        int expectNum = val;
        while (expectNum > 0) {
            // 库存已满
            while (size >= capacity) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int inc = (size + expectNum) > capacity ? (capacity - size) : expectNum;
            size += inc;
            expectNum -= inc;

            System.out.printf("Current capacity %s size %s Thread %s expectNum %s produce %s left %s \n", capacity, size, Thread.currentThread().getName(), val, inc, expectNum);
            notifyAll();
        }
    }

    public synchronized void consume(int val) {
        System.out.printf("Current capacity %s size %s Thread %s \n", capacity, size, Thread.currentThread().getName());
        int expectNum = val;
        while (expectNum > 0) {
            while (size <= 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int dec = (size < expectNum) ? size : expectNum;
            size -= dec;
            expectNum -= dec;

            System.out.printf("Current capacity %s size %s Thread %s expectNum %s consume %s left %s \n", capacity, size, Thread.currentThread().getName(), val, dec, expectNum);
            notifyAll();
        }
    }
}
