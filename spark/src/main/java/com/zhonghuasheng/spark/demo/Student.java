package com.zhonghuasheng.spark.demo;

import java.io.Serializable;

public class Student implements Serializable {

    private String name;
    private boolean gaoKao;
    private String sex;
    private int age;
    private int count;

    public Student(boolean gaoKao, String sex, String name, int age) {
        this.name = name;
        this.gaoKao = gaoKao;
        this.sex = sex;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGaoKao() {
        return gaoKao;
    }

    public void setGaoKao(boolean gaoKao) {
        this.gaoKao = gaoKao;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
