package com.zhonghuasheng.basic.test;

public class TestClassForName {

    public static void main(String[] args) {
        try {
            Class.forName("com.zhonghuasheng.basic.test.ClassForNameTarget");
            System.out.println("----华丽分割线----");
            ClassLoader classLoader = ClassForNameTarget.class.getClassLoader();
            classLoader.loadClass("com.zhonghuasheng.basic.test.ClassForNameTarget");
        } catch (ClassNotFoundException e) {
        }

    }
}
