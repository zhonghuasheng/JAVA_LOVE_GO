package com.zhonghuasheng.springcloud.feign.config;

import com.zhonghuasheng.springcloud.feign.service.EurekaClientFeign;
import org.springframework.stereotype.Component;

@Component
public class HiHystrix implements EurekaClientFeign {

    @Override
    public String sayHiFromEurekaClient(String name) {
        return "hi, " + name + ", sorry, error!";
    }
}
