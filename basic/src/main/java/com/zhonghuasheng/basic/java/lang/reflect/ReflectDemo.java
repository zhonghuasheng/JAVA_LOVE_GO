package com.zhonghuasheng.basic.java.lang.reflect;

import java.util.ArrayList;

public class ReflectDemo {

    public static void main(String[] args) {
        ClassUtil.showClassInfo(User.class);
        ClassUtil.showConstructorInfo(User.class);
        ClassUtil.showMethodsInfo(User.class);

        ArrayList<String> list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        System.out.println(list1 == list2);
    }
}
