package com.zhonghuasheng.basic.btrace;

import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /*Calculator calculator = new Calculator();
        Random random = new Random();
        boolean isExit = false;

        while (!isExit) {
            System.out.println(calculator.add(random.nextDouble(), random.nextDouble()));
        }*/

        Thread.sleep(20000);

        HashMap<String, String> values = new HashMap<String, String>();
        values.put(null, "1");

        for (int i = 1; i < 18; i++) {
            values.put(String.valueOf(i), String.valueOf("value " + i));
        }

        System.out.println("done");
    }
}
