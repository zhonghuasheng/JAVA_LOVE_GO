package com.zhonghuasheng.basic.java.util.concurrent;

public class DCLSingleton {

    private volatile static DCLSingleton dclSingleton;

    public static DCLSingleton getDclSingleton() {
        if (dclSingleton == null) {
            synchronized (DCLSingleton.class) {
                if (dclSingleton == null) {
                    dclSingleton = new DCLSingleton();
                }
            }
        }

        return dclSingleton;
    }

    public static void main(String[] args) {
        DCLSingleton.getDclSingleton();
    }
}
