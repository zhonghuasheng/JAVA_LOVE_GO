package com.zhonghuasheng.basic.java.thread;

public class NewThreadThread {

    public static void main(String[] args) {
        Thread thread = new NewThread("newThread");
        thread.start(); // 启动子线程运行
        // 主线程继续运行
        for (int i = 0; i < 2000; i++) {
            System.out.println(i);
        }
    }
}

// 继承自Thread类
class NewThread extends Thread {

    public NewThread(String name) {
        super.setName(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Thread running");
        try {
            Thread.sleep(200); //会让当前线程暂停
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " Thread done");
    }
}
