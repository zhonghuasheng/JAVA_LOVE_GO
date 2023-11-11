package com.zhonghuasheng.basic.java.gc;

public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
        // 程序运行的结果没有发生Full GC，也就是说JVM虚拟机没有通过计数算法来判断对象是否存活
    }
}
