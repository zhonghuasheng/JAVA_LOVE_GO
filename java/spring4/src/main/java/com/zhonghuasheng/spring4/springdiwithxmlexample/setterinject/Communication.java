package com.zhonghuasheng.spring4.springdiwithxmlexample.setterinject;


public class Communication {

    private Messaging messaging;

    /*
     * DI via Setter
     * */
    public void setMessaging(Messaging messaging) {
        this.messaging = messaging;
    }

    public void communicate() {
        messaging.sendMessage();
    }
}
