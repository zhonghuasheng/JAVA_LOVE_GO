package com.zhonghuasheng.spring4.event;

import org.springframework.context.ApplicationEvent;

public class LogEvent extends ApplicationEvent {

    private String msg;

    public LogEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
