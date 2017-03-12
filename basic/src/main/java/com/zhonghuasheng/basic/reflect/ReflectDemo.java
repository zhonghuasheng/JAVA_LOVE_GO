package com.zhonghuasheng.basic.reflect;

public class ReflectDemo {

    public static void main(String[] args) {
        ClassUtil.showClassInfo(User.class);
        ClassUtil.showConstructorInfo(User.class);
        ClassUtil.showMethodsInfo(User.class);
    }
}
