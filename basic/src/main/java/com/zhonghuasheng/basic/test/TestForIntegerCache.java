package com.zhonghuasheng.basic.test;

public class TestForIntegerCache {

    public static void main(String[] args) {
        Integer a = 101;
        Integer b = 101;
        Integer c = 200;
        Integer d = 200;

        System.out.println(a==b);
        System.out.println(c==d);
    }
}
