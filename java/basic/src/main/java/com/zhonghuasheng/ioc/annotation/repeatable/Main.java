package com.zhonghuasheng.ioc.annotation.repeatable;

import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) {
        Annotation[] annotations = ValueTest.class.getMethods()[0].getAnnotations();
        Values annotation = (Values) annotations[0];
        System.out.println(annotation.value()[0].value());
        System.out.println(annotation.value()[1].value());
    }
}
