package com.zhonghuasheng.spring4.profileannotation.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.zhonghuasheng.spring4.profileannotation")
public class AppConfig {

    @Autowired
    public DataSource dataSource;
}
