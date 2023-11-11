package com.zhonghuasheng.basic.java.util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.synchronizedList;

public class CollectionsExample {

    public static void main(String[] args) {
        // Collections sort for Integer object
        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(3);
        integerList.add(1);
        integerList.add(5);

        Collections.sort(integerList);

        for (Integer i : integerList) {
            System.out.println(i);
        }
        System.out.println("Collections sort for Integer object");

        // Collections sort for String object
        List<String> stringList = new ArrayList<String>();
        stringList.add("az12345");
        stringList.add("sw");
        stringList.add("de");
        //stringList.add(null);

        Collections.sort(stringList);

        for (String s : stringList) {
            System.out.println(s);
        }

        Collections.sort(stringList, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1 == null || o2 == null) {
                    return -1;
                } else {
                    return o1.length() < o2.length() ? 1 : -1;
                }
            }
        });

        for (String s : stringList) {
            System.out.println(s);
        }
        System.out.println("Collections sort for String object");

        // Collections addAll
        Collections.addAll(stringList, "c", "d");
        for (String s : stringList) {
            System.out.println(s);
        }
        System.out.println("Collections addAll");

        // Collections copy是浅拷贝
        List<String> dest = new ArrayList<String>();
        dest.add("1");
        dest.add("2");
        dest.add("3");
        dest.add("4");
        dest.add("5");
        dest.add("6");
        Collections.copy(dest, stringList);

        for (String s : dest) {
            System.out.println(s);
        }
        System.out.println(dest.get(0).hashCode() + " : " + stringList.get(0).hashCode());
        System.out.println(dest.get(0) == stringList.get(0)); // true
        dest.set(0, "replace"); // dest在初始化的时候已经分配了地址，所以stringList.get(0)值不变
        System.out.println(stringList.get(0));
        System.out.println("Collections copy(dest, src)");

        // Collections max
        System.out.println(Collections.max(integerList)); // 5 调用compareTo比较对象大小
        System.out.println("Collections max() to get the max value");

        // Collections min
        System.out.println(Collections.min(stringList));

        // Collection reverse 反转
        Collections.reverse(integerList);
        for (Integer i : integerList) {
            System.out.println(i);
        }

        // Collections emptyList 返回一个空的List
        System.out.println(Collections.emptyList().size());

        // 通过集合Collections.synchronizedList将其转换为一个线程安全的类
        List<String> synchronizedList = Collections.synchronizedList(dest);
    }

    class People {

        private String name;
        private int age;

        public People(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
    }
}
