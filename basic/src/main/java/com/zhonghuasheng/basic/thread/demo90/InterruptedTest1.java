package com.zhonghuasheng.basic.thread.demo90;

public class InterruptedTest1 {

    public static void main(String[] args) throws InterruptedException {
        MyThread mt1 = new MyThread("mt1");
        System.out.println("After new thread " + mt1.getName() + " current state is " + mt1.getState());

        mt1.start();
        System.out.println("After start thread " + mt1.getName() + " current state is " + mt1.getState());

        Thread.sleep(2000);
        mt1.interrupt();
        System.out.println("Interrupted thread " + mt1.getName() + " current state is " + mt1.getState());

        Thread.sleep(2000);
        System.out.println("Current thread " + mt1.getName() + " current state is " + mt1.getState());
    }

}
