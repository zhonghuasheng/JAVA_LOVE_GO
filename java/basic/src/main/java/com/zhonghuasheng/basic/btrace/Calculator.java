package com.zhonghuasheng.basic.btrace;

public class Calculator {

    public double add(double x, double y) throws InterruptedException {
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {

        }
        return x + y;
    }
}
