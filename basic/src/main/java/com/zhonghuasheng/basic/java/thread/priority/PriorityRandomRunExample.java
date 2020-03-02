package com.zhonghuasheng.basic.java.thread.priority;

public class PriorityRandomRunExample {
    public static void main(String[] args) {
        ThreadPriorityA threadPriorityA = new ThreadPriorityA();
        ThreadPriorityB threadPriorityB = new ThreadPriorityB();
        threadPriorityA.setPriority(9);
        threadPriorityB.setPriority(1);
        threadPriorityA.start();
        threadPriorityB.start();
        /**
         * 随机运行
         * Thread-1: 1
         * Thread-0: 9
         * Thread-0: 9
         * Thread-0: 9
         * Thread-1: 1
         * Thread-0: 9
         * Thread-1: 1
         * Thread-0: 9
         * ......
         * Process finished with exit code 0
         */
    }
}
class ThreadPriorityA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority());
        }
    }
}

class ThreadPriorityB extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getPriority());
        }
    }
}