package com.zhonghuasheng.basic.java.lang.thread.demo5;

public class WaitTest {

    public static void main(String[] args) {
        // "主线程"通过new MyThread("t1")新建"线程t1"
        MyThread t1 = new MyThread("t1");

        // 主线程获得“t1对象同步锁”
        synchronized (t1) {
            try {
                // 启动“线程t1”
                System.out.println(Thread.currentThread().getName() + " start t1");
                t1.start();
                // 虽然此时启动了线程t1，但是线程t1对象锁归主线程所有，因此线程t1出于block状态

                System.out.println(Thread.currentThread().getName() + " wait()");
                /**
                 * 主线程调用t1.wait()来释放“t1同步锁”，并且进入了“等待”状态，等待t1对象上的线程通过notify()
                 * 或者notifyAll()将其唤醒。线程t1获取了“当前对象的锁”，接着调用notify()唤醒"当前对象上的等待线程"
                 */
                t1.wait();

                // 线程t1运行完毕之后，主线程获取了"t1同步锁"
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
