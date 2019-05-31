package com.zhonghuasheng.basic.java.thread.demo3;

public class StartAndRunTest {

    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread("my test thread ");
        mt.start();
        Thread.sleep(1000);
        mt.run();
        /**
         * Thread.start()会启动一个新线程，并在新线程中运行run方法
         * Thread.run()则是直接在当前线程中运行run()方法，并不会启动一个新的线程
         */
    }
}
