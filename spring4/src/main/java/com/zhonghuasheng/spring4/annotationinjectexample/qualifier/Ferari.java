package com.zhonghuasheng.spring4.annotationinjectexample.qualifier;

import org.springframework.stereotype.Component;

@Component("Ferari")
public class Ferari implements Car {

    public void getCarName() {
        System.out.println("This is Ferari");
    }
}
