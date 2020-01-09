package com.zhonghuasheng.netty.tcp.pojo;

import com.alibaba.fastjson.annotation.JSONField;

public class Person {

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "age")
    private int age;

    public Person(String name, int age) {
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
