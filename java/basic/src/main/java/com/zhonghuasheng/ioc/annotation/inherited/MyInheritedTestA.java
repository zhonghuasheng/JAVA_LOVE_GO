package com.zhonghuasheng.ioc.annotation.inherited;

@MyInherited
public class MyInheritedTestA {

    public static void main(String[] args) {
        System.out.println(MyInheritedTestB.class.getAnnotations()[0].toString());
        System.out.println(MyInheritedTestC.class.getAnnotations()[0].toString());
    }
}
