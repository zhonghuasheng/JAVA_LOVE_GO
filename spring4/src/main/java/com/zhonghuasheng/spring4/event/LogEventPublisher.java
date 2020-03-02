package com.zhonghuasheng.spring4.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class LogEventPublisher {

    @Autowired
    private ApplicationContext applicationContext;

    public void publishLogEvent(String msg) {
        applicationContext.publishEvent(new LogEvent(this, msg));
    }
}
