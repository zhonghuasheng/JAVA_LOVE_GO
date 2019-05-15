package com.zhonghuasheng.basic.java.test;

public class TestForIntegerCache {

    public static void main(String[] args) {
        /*
        * Java对Integer类型的值-128至127进行了缓存，具体可以查看Integer#valueOf(x)方法
        * IntegerCache
        * */
        Integer a = 101;
        Integer b = 101;
        Integer c = 200;
        Integer d = 200;

        System.out.println(a==b); // true
        System.out.println(c==d); // false

        /*
        * new Integer()会创建一个对象，但是值还是指向的是IntegerCache中的值
        * */
        Integer x1 = new Integer(101);
        Integer x2 = new Integer(101);
        System.out.println(x1==x2); // false

        /*
        * Test for String
        * */
        String x3 = new String("abc");
        String x4 = new String("abc");
        System.out.println(x3 == x4); // false

        String x5 = "abcd";
        String x6 = "abcd";
        System.out.println(x5 == x6); // true

        System.out.println(Integer.MAX_VALUE); // 2 sup 31 -1  2147483647
        System.out.println(Integer.MIN_VALUE); // -2 sup 31  -2147483648
    }
}
