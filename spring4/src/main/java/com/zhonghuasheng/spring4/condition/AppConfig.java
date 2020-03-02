package com.zhonghuasheng.spring4.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.zhonghuasheng.spring4.condition")
public class AppConfig {

    @Bean
    @Conditional(WindowsCondition.class)
    public CommandShow windowsCommandShow() {
        return new WindowsCommandShow();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public CommandShow linuxCommandShow() {
        return new LinuxCommandShow();
    }
}
