package com.zhonghuasheng.spring4.el;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.zhonghuasheng.spring4.el")
// 加载资源文件
@PropertySource("classpath:el-test.properties")
public class AppConfig {

    // 必须要有这个Configurer Bean,否则无法将properties中的值赋值给el表达式
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
