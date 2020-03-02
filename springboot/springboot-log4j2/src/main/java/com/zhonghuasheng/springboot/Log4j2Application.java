package com.zhonghuasheng.springboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4j2Application implements ApplicationRunner {

    private static final Logger logger = LogManager.getLogger(Log4j2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Log4j2Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("Debugging log");
        logger.info("Info log");
        logger.warn("Warning log");
        logger.error("Error log");
        logger.fatal("Fatal log");
    }
}
