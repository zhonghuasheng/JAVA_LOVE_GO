package com.zhonghuasheng.basic.java.util.concurrent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VolatileOrderlinessExample {

    private static int x, y;
    private volatile static int m, n;

    public static void main(String[] args) throws InterruptedException {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> hashMapB = new HashMap<String, Integer>();
        Set<String> setB = new HashSet<>();

        for (int i = 0; i < 1000000; i++) {
            hashMap.clear();
            hashMapB.clear();
            m = n = x = y = 0;
            Thread thread1 = new Thread(new Runnable() {
                public void run() {
                    int a = x;
                    y = 1;
                    hashMap.put("a", a);
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                public void run() {
                    int b = y;
                    x = 1;
                    hashMap.put("b", b);
                }
            });
            /*Thread thread3 = new Thread(new Runnable() {
                public void run() {
                    int a = m;
                    n = 1;
                    hashMapB.put("m", a);
                }
            });
            Thread thread4 = new Thread(new Runnable() {
                public void run() {
                    int b = n;
                    m = 1;
                    hashMapB.put("n", b);
                }
            });*/
            thread1.start();
            thread2.start();
            //thread3.start();
            //thread4.start();
            thread1.join();
            thread2.join();
            //thread3.join();
            //thread4.join();
            set.add("[a= " + hashMap.get("a") + ", b= " + hashMap.get("b") + "]");
            // 这种情况下会出现 [0, 1] [1, 0] [0, 0] [1, 1]的情况，出现[1, 1]是因为指令重排，x=1比int b = y先执行
            System.out.println(set);
            //setB.add("[m= " + hashMapB.get("m") + ", n= " + hashMapB.get("n") + "]");
            //System.out.println("[a= " + aArr[0] + ", b= " + aArr[1] + "]");
            // 这种情况下会出现 [0, 1] [1, 0] [0, 0]的情况，volatile禁止计算机指令重排
            //System.out.println(setB);
        }
    }
}
