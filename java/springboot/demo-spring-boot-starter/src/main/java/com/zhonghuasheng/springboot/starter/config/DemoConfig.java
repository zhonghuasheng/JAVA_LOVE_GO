package com.zhonghuasheng.springboot.starter.config;

import com.zhonghuasheng.springboot.starter.properties.DemoProperties;
import com.zhonghuasheng.springboot.starter.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnProperty(
        prefix = "demo",
        name = "isOpen",
        havingValue = "true"
)
public class DemoConfig {

    @Autowired
    private DemoProperties demoProperties;

    @Bean(name = "demo")
    public DemoService demoService() {
        return new DemoService(demoProperties.getUserName(), demoProperties.getAge());
    }
}
