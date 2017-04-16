package com.zhonghuasheng.basic.thread.demo6;

public class WaitTimeOutTest {

    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");

        try {
            synchronized(t1) {
                // 主线程开启t1，但此时t1线程的同步锁归主线程所有，t1线程对于t1对象出于等待状态
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();

                // 主线程调用t1.wait(3000)来释放t1同步锁3秒，超时后唤醒主线程，这里是超时，如果3秒内被唤醒将继续执行
                // 可以理解为早点回来早点执行，最多等你3秒
                t1.wait(3000);
                System.out.println(Thread.currentThread().getName() + " continue");
            } 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
