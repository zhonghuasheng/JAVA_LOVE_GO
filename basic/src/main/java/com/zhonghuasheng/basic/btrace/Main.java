package com.zhonghuasheng.basic.btrace;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Calculator calculator = new Calculator();
        Random random = new Random();
        boolean isExit = false;

        while (!isExit) {
            System.out.println(calculator.add(random.nextDouble(), random.nextDouble()));
        }
    }
}
