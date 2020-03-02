package com.zhonghuasheng.spring4.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TrackingLogListener implements ApplicationListener<LogEvent> {

    @Override
    public void onApplicationEvent(LogEvent event) {
        System.out.println("TrackingLogListener handle this event: " + event.getMsg());
    }
}
