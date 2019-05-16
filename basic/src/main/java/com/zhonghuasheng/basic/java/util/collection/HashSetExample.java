package com.zhonghuasheng.basic.java.util.collection;

import java.util.HashSet;

public class HashSetExample {

    public static void main(String[] args) {
        HashSet<String> values = new HashSet<String>();
        values.add("a");
        values.add("b");
        values.add("a"); // 不允许有重复元素

        for (String value : values) {
            System.out.println(value);
        }
    }

}
