package com.zhonghuasheng.springboot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    private Logger logger = LogManager.getLogger(LogController.class);

    @RequestMapping("/loglevel")
    public String logLevel() {
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");

        return "success";
    }
}
