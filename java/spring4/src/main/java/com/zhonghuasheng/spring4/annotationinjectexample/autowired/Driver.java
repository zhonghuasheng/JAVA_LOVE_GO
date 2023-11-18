package com.zhonghuasheng.spring4.annotationinjectexample.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Driver {

    // 如果没有License这个Bean被发现，也不会报错，license将会为null
    @Autowired(required=false)
    private License license;

    @Override
    public String toString() {
        return "Driver [license=" + license + "]";
    }
}
