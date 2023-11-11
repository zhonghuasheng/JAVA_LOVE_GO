package com.zhonghuasheng.springcloud.feign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {

    @Autowired
    EurekaClientFeign eurekaClientFeign;

    public String sayHi(String name) {
        return eurekaClientFeign.sayHiFromEurekaClient(name);
    }
}
