package com.zhonghuasheng.basic.test;

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

        System.out.println(a==b);
        System.out.println(c==d);

        /*
        * new Integer()会创建一个对象，但是值还是指向的是IntegerCache中的值
        * */
        Integer x1 = new Integer(101);
        Integer x2 = new Integer(101);
        System.out.println(x1==x2);
    }
}
