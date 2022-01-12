package com.zhonghuasheng.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @GetMapping("/hystrix")
    @HystrixCommand(fallbackMethod = "fallbackMethod", commandProperties = {
        // 设置超时时间，默认1秒
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
        // 监控时间，默认5秒
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
        // 失败次数，默认20次
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "20"),
        // 失败了，默认50%
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    })
    public String sayHi() {
/*      // 1. 容错，此处逻辑抛出异常，会走熔断方法
        int i = 3 / 0;*/
        // 2. 响应超时熔断
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        return "hi";
    }

    /**
     * 熔断方法
     * @return String
     */
    private String fallbackMethod() {
        return "熔断了";
    }
}
