package com.zhonghuasheng.basic.java.thread.exception;

public class UncaughtExceptionExample {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 2; i > -1 ; i--) {
                    System.out.println(10 / i);
                }
            }
        }, "ThreadA ");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Caught exception in thread " + t.getName());
                System.out.println("Exception is " + e.getMessage());
            }
        });
        thread.start();
        /**直接运行的结果
         * 5
         * Exception in thread "Thread-0" java.lang.ArithmeticException: / by zero
         * 10
         * 	at com.zhonghuasheng.basic.java.thread.exception.UncaughtExceptionExample$1.run(UncaughtExceptionExample.java:10)
         * 	at java.lang.Thread.run(Thread.java:745)
         ** 加了UncaughtExceptionHandler运行的结果
         * 5
         * 10
         * Caught exception in thread ThreadA
         * Exception is / by zero
         *
         * Process finished with exit code 0
         */
    }
}
