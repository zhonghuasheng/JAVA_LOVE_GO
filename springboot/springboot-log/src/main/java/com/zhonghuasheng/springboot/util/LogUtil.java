package com.zhonghuasheng.springboot.util;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

import java.util.List;

public class LogUtil {

    public static void setAllLogLevel(String level) {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        List<Logger> loggerList = loggerContext.getLoggerList();
        for (Logger logger : loggerList) {
            System.out.println(logger.getName());
            logger.setLevel(Level.toLevel(level));
        }
    }

    public static void setLogLevel(String level, String classFullName) {
        Logger logger = (Logger) LoggerFactory.getLogger(classFullName);
        System.out.println(logger.getName() + ": " + logger.getLevel());
        logger.setLevel(Level.toLevel(level));
    }
}
