package com.zhonghuasheng.spring4.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.zhonghuasheng.spring4.beanlifecycle")
public class AppConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanWayUserService getBean() {
        return new BeanWayUserService();
    }
}
