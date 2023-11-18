package com.zhonghuasheng.basic.java.thread.lock;

public class Main {

    public static void main(String[] args) {
/*        final Phone phone1 = new Phone();

        new Thread("Thread " + 1) {
            @Override
            public void run() {
                phone1.call();
            }
        }.start();

        new Thread("Thread " + 2) {
            @Override
            public void run() {
                phone1.message();
            }
        }.start();*/

        System.out.println("-------------");
        for(int i = 0; i < 10; i++) {
            final Phone phone = new Phone("name " + i);
            new Thread(phone.getName()) {
                @Override
                public void run() {
                    phone.call();
                }
            }.start();
        }
    }
}
