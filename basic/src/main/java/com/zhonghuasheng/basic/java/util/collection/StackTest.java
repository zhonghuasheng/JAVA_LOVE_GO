package com.zhonghuasheng.basic.java.util.collection;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<String> values = new Stack<String>();
        values.add("1");
        values.add("2");
        values.add("3");
        values.add("4");
        values.add("5");
        System.out.println(values.peek());
        System.out.println(values.pop());
        System.out.println(values.push("a"));
    }
}
