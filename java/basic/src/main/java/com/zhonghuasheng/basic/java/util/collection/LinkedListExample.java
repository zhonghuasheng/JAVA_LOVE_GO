package com.zhonghuasheng.basic.java.util.collection;

import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {
        LinkedList<String> values1 = new LinkedList<String>();
        values1.add("a");
        values1.add("b");
        values1.add("c");

        LinkedList<String> values2 = (LinkedList) values1.clone();
        System.out.println("After clone: " + values2);

        values2.set(0, "update");
        System.out.println("values1: " + values1 + " || values2: " + values2);

        values1.set(1, "update");
        System.out.println("values1: " + values1 + " || values2: " + values2);

        LinkedList<Person> persons1 = new LinkedList<Person>();
        Person jack = new Person("Jack");
        persons1.add(jack);
        Person rose = new Person("Rose");
        persons1.add(rose);

        // 浅拷贝
        LinkedList<Person> persons2 = (LinkedList<Person>) persons1.clone();
        for (Person p : persons2) {
            System.out.println(p.name);
        }

        jack.name = "Jackson";

        for (Person p : persons2) {
            System.out.println(p.name);
        }

        // 获取第一个元素
        persons2.element();

        values2.clear();
        values2.add("a");

    }

}

class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}
