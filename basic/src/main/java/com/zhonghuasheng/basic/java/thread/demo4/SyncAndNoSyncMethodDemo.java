package com.zhonghuasheng.basic.java.lang.thread.demo4;

public class SyncAndNoSyncMethodDemo {

    public static void main(String[] args) {
        final Count count = new Count();
        /**
         * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，其他线程
         * 仍然可以访问“该对象”的非同步代码块
         */
        new Thread(new Runnable() {
            public void run() {
                count.syncMethod();
            }
        }, "t1").start();;

        new Thread(new Runnable() {
            public void run() {
                count.nonSyncMethod();
            }
        }, "t2").start();;
    }
}
