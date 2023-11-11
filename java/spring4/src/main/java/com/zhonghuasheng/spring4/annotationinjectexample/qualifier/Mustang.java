package com.zhonghuasheng.spring4.annotationinjectexample.qualifier;

import org.springframework.stereotype.Component;

@Component("Mustang")
public class Mustang implements Car {

    @Override
    public void getCarName() {
        System.out.println("This is Mustang");
    }
}
