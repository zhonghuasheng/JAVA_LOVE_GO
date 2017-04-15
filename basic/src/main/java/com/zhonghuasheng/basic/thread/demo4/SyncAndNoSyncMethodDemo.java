package com.zhonghuasheng.basic.thread.demo4;

public class SyncAndNoSyncMethodDemo {

    public static void main(String[] args) {
        final Count count = new Count();

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
