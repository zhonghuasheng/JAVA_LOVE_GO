package com.zhonghuasheng.rabbitmq.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class Producer {

    public void sendMessage() throws IOException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(Constants.EXCHANGE_NAME, Constants.EXCHANGE_TYPE_FANOUT);
        String msg = "Hello Fanout";
        // 这里即使加了routingKey，在fanout模式下也会被忽略
        channel.basicPublish(Constants.EXCHANGE_NAME, "test", null, msg.getBytes("UTF-8"));
        System.out.println("Sent message: " + msg + " to exchange: " + channel.getChannelNumber());
    }
}
