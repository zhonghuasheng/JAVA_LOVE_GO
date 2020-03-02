package com.zhonghuasheng.rabbitmq.basic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.zhonghuasheng.rabbitmq.basic.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    private static final String QUEUE_NAME = "test.simple.queues";

    public void sendMessage() {
        try {
            Connection connection = ConnectionUtils.getConnection();
            Channel channel = connection.createChannel();
            // 队列的持久化 durable=true
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);
            String msg = "Hello World! 你好世界！";
            // 消息的持久化 MessageProperties.PERSISTENT_TEXT_PLAIN
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, msg.getBytes());
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
