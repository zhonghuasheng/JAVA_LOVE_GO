package com.zhonghuasheng.basic.java.util.map;

import java.util.Hashtable;

public class HashTableExample {

    public static void main(String[] args) {
        Hashtable<String, String> values = new Hashtable<String, String>();
        values.put("a", "1");
        values.put("e", "3");
        values.put("a", "4");
        values.put("d", "5");

        // 无序，不重复， HashTable继承自Set，那么元素就不会有重复的key
        System.out.println(values.size());
        /*values.put(null, "a"); // Hashtable不允许key或者value为null，HashMap允许
        System.out.println(values.size());*/
    }
}
