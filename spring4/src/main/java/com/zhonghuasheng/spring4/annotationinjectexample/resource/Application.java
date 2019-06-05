package com.zhonghuasheng.spring4.annotationinjectexample.resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("application")
public class Application {

    @Resource( name = "applicationUser" )
    private ApplicationUser applicationUser;

    @Override
    public String toString() {
        return "Application [applicationUser=" + applicationUser + "]";
    }
}
