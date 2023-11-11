package com.zhonghuasheng.springboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class Log4j2Application {
    /**
     * 这个demo是springboot集成log4j2，具有以下功能：
     * 1. 可以做到按应用名建立文件夹，分门别类的统计日记。具体可以看log4j2的lookup，主要是通过log4j2来读取配置的变量实现。
     * 2. 按文件大小或者按天来rolling日志文件
     * 3. 增加日志的格式化模式，比如前缀，这样的话可以方便后期集成到ELK中
     */

    public static void main(String[] args) {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        Properties property = yaml.getObject();
        System.setProperty("SERVICE_NAME", property.getProperty("spring.application.name"));
        System.setProperty("FILE_PATH", property.getProperty("logging.file.path"));
        SpringApplication.run(Log4j2Application.class, args);
        System.out.println("项目启动完毕");
    }
}
