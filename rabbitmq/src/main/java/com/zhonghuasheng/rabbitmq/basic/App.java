package com.zhonghuasheng.rabbitmq.basic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        for (int i = 0; i < 9; i++) {
            new Producer().sendMessage();
            System.out.println(i);
        }
        Thread.sleep(10000);
        //new Consumer().receiveMessage();
    }
}
