package com.zhonghuasheng.springboot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component

/**
 * 在springboot启动后执行会阻塞其他的调用，ApplicationRunner和CommandLinerRunner接口都是在main的run方法中执行afterRefresh方法触发callRunners，如果自己写的run方法中是个死循环，就导致了主线程的main一直阻塞
 */
public class LogApplicationRunner implements ApplicationRunner {

    private static final Logger logger = LogManager.getLogger(LogApplicationRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (true) {
            logger.debug("Debugging log-----------------------------------------------------------------------------");
            logger.info("Info log-----------------------------------------------------------------------------");
            logger.warn("Warning log-----------------------------------------------------------------------------");
            logger.error("Error log-----------------------------------------------------------------------------");
            logger.fatal("Fatal log-----------------------------------------------------------------------------");
            Thread.sleep(20000);
        }
    }
}
