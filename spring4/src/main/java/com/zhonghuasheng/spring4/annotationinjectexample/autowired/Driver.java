package com.zhonghuasheng.spring4.annotationinjectexample.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Driver {

    @Autowired
    private License license;

    @Override
    public String toString() {
        return "Driver [license=" + license + "]";
    }
}
