package com.zhonghuasheng.basic.java.classloader;

import java.net.URL;

/**
 * 找出加载的JDK包
 */
public class BootStrapClassLoader {

    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();

        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }

}
