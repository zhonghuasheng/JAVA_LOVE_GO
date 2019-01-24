package com.zhonghuasheng.basic.classloader;

public class ClassLoaderTest {

    static {
        System.out.println("test");
    }

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();

        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }

        System.out.println(classLoader);
    }
}
