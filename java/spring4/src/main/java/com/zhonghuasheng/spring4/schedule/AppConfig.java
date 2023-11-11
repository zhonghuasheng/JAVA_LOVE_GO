package com.zhonghuasheng.spring4.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = "com.zhonghuasheng.spring4.schedule")
@EnableScheduling
public class AppConfig {
}
