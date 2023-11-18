package com.zhonghuasheng.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApp.class, args);
    }
}
