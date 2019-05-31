package com.zhonghuasheng.basic.java.classloader;

public class Test {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();

        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }

        System.out.println(classLoader);// TODO Auto-generated method stub

    }

}
