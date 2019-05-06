package com.zhonghuasheng.basic.test;

public class PassByValueOrReference {

    public static void main(String[] args) {
        /*
        * Java是值传递，不是引用传递
        * https://stackoverflow.com/questions/40480/is-java-pass-by-reference-or-pass-by-value
        * */
        Dog aDog = new Dog("Max");
        System.out.println("aDog hashcode: " + aDog.hashCode());
        Dog oldDog = aDog;
        System.out.println("oldDog hashcode: " + oldDog.hashCode());
        foo(aDog);
        System.out.println(aDog.getName().equals("Max"));
        System.out.println(aDog.getName().equals("Fifi"));
        System.out.println(aDog == oldDog);
    }

    public static void foo(Dog d) {
        System.out.println("d hashcode: " + d.hashCode());
        System.out.println(d.getName().equals("Max"));
        d = new Dog("Fifi");
        //d.setName("Fifi");
        System.out.println(d.getName().equals("Fifi"));
    }
}
