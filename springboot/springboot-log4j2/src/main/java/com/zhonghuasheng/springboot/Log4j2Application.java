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
public class Log4j2Application implements ApplicationRunner {

    private static final Logger logger = LogManager.getLogger(Log4j2Application.class);

    public static void main(String[] args) {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("application.yml"));
        Properties property = yaml.getObject();
        System.setProperty("SERVICE_NAME", property.getProperty("spring.application.name"));
        SpringApplication.run(Log4j2Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (true) {
            logger.debug("Debugging log-----------------------------------------------------------------------------");
            logger.info("Info log-----------------------------------------------------------------------------");
            logger.warn("Warning log-----------------------------------------------------------------------------");
            logger.error("Error log-----------------------------------------------------------------------------");
            logger.fatal("Fatal log-----------------------------------------------------------------------------");
            logger.debug("Debugging log-----------------------------------------------------------------------------");
            logger.info("Info log-----------------------------------------------------------------------------");
            logger.warn("Warning log-----------------------------------------------------------------------------");
            logger.error("Error log-----------------------------------------------------------------------------");
            logger.fatal("Fatal log-----------------------------------------------------------------------------");
            logger.debug("Debugging log-----------------------------------------------------------------------------");
            logger.info("Info log-----------------------------------------------------------------------------");
            logger.warn("Warning log-----------------------------------------------------------------------------");
            logger.error("Error log-----------------------------------------------------------------------------");
            logger.fatal("Fatal log-----------------------------------------------------------------------------");
            Thread.sleep(3000);
        }
    }
}
