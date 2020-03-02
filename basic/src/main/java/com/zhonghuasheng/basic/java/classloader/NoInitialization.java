package com.zhonghuasheng.basic.java.classloader;

public class NoInitialization {

    public static void main(String[] args) {
        /**
        * 程序执行结果。
        * SuperClass init!
        * 123
        * 子类的静态代码块没有执行，说明子类没有初始化。静态字段，只有直接定义这个字段的类才会被初始化。
        */
        System.out.println(SubClass.value);

        // 编译阶段静态常量存储到了常量池
        System.out.println(ConstClass.HELLOWORLD);
    }
}
