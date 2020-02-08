package com.zhonghuasheng.basic.java.classloader;

public class ConstClass {

    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORLD = "Hello World!";
}
