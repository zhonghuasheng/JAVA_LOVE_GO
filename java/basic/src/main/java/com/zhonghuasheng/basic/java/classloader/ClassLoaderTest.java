package com.zhonghuasheng.basic.java.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 比较两个类是否相等
 * 两个类相等的条件是由同一个类加载器加载，并且这两个类来源于同一个class文件
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if (is == null) {
                    return super.loadClass(name);
                }
                byte[] b = new byte[0];
                try {
                    b = new byte[is.available()];
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    is.read(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return defineClass(name, b, 0, b.length);
            }
        };
        Object obj = classLoader.loadClass("com.zhonghuasheng.basic.java.classloader.ClassLoaderTest");
        System.out.println(((Class) obj).getName());
        System.out.println(obj instanceof com.zhonghuasheng.basic.java.classloader.ClassLoaderTest);
    }
}
