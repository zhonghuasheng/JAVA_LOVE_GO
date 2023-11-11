package com.zhonghuasheng.basic.java.classloader;

public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }
}
