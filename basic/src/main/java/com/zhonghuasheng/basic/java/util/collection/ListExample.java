package com.zhonghuasheng.basic.java.util.collection;

import java.util.List;
import java.util.ArrayList;

public class ListExample {

    public static void main(String[] args) {
        List<String> values = new ArrayList<String>();
        values.add("same value");
        values.add("same value");
        values.add("same value");
        System.out.println(values.get(0));
        values.add(0, "a");
        values.add(0, "b"); // 只会添加元素，不会覆盖掉
        values.set(0, "set"); // 覆盖元素
        System.out.println(values.indexOf("same value")); // 返回第一个对象的index
        System.out.println(values.lastIndexOf("same value")); //返回最后一个对象的index

        for (String value : values) {
            System.out.println(value);
        }

        System.out.println("----------");
        List<String> values2 = new ArrayList<String>(values);
        values2.add("c");
        values2.add("d");
        values2.add("e");
        values2.retainAll(values);
        System.out.println("----------");
        for (String value : values2) {
            System.out.println(value);
        }

        values2.containsAll(values);
    }

}
