package com.zhonghuasheng.basic.java.thread.demo9;

public class JoinTest {

    public static void main(String[] args) {
        MyThread mt1 = new MyThread("mt1");
        mt1.start();

        try {
            // 让主线程等待子线程mt1完成后再执行
            mt1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished");
    }

}
