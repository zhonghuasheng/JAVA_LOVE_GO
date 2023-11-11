package com.zhonghuasheng.spring4.springdiwithxmlexample.setterinject.service.impl;

import com.zhonghuasheng.spring4.springdiwithxmlexample.setterinject.Messaging;

public class ActiveMQMessaging implements Messaging {

    @Override
    public void sendMessage() {
        System.out.println("Sending Message via Active MQ");
    }
}
