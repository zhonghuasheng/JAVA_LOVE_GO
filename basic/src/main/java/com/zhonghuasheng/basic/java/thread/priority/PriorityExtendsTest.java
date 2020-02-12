package com.zhonghuasheng.basic.java.thread.priority;

public class PriorityExtendsTest {

    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.setPriority(8);
        ClassB classB = new ClassB();
        classB.start();
        classA.start();
        /** 不存在继承关系
         * Current Thread Thread-1 priority is 5
         * Current Thread Thread-0 priority is 8
         */
    }
}

class ClassA extends Thread {
    @Override
    public void run() {
        System.out.println("Current Thread " + Thread.currentThread().getName() + " priority is " + Thread.currentThread().getPriority());
    }
}

class ClassB extends ClassA {
    @Override
    public void run() {
        System.out.println("Current Thread " + Thread.currentThread().getName() + " priority is " + Thread.currentThread().getPriority());
    }
}
