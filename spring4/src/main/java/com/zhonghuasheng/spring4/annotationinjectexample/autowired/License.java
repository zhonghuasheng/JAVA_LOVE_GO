package com.zhonghuasheng.spring4.annotationinjectexample.autowired;

import org.springframework.stereotype.Component;

@Component
public class License {

    private String number = "DBCA 1314";

    @Override
    public String toString() {
        return "License [number=" + number + "]";
    }
}
