package com.zhonghuasheng.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:user-config.properties")
public class PropertiesConfig {

    @Value("I LOVE YOU!") // 注入普通字符串
    public String normal;

    @Value("#{systemProperties['os.name']}") // 注入操作系统信息
    public String osName;

    @Value("#{T(Math).random() * 100}") // 注入随机数
    public String randomNumber;

    @Value("http://www.baidu.com")
    public Resource testUrl;

    @Value("classpath:/test.txt") // 注入文件资源
    public Resource testFile;

    @Autowired
    private Environment environment;

    public static PropertySourcesPlaceholderConfigurer propertyConfigurer () {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
