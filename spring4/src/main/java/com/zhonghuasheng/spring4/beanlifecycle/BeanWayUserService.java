package com.zhonghuasheng.spring4.beanlifecycle;

public class BeanWayUserService {

    public void init() {
        System.out.println("BeanWayUserService init method");
    }

    public BeanWayUserService() {
        System.out.println("BeanWayUserService Constructor");
    }

    public void destroy() {
        System.out.println("BeanWayUserService destroy");
    }
}
