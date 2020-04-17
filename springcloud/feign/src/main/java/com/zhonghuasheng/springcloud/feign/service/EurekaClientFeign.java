package com.zhonghuasheng.springcloud.feign.service;

import com.zhonghuasheng.springcloud.feign.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client", configuration = FeignConfig.class)
public interface EurekaClientFeign {

    @GetMapping("/hi")
    String sayHiFromEurekaClient(@RequestParam("name") String name);
}
