package com.zhonghuasheng.rabbitmq.fanout;


import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public void sendMessage() throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(Constants.EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        // 指定消息投递模式： 消息的确认模式
        channel.confirmSelect();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {
                System.out.println(l +  "" + b + " ack");
            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {
                System.out.println(l +  "" + b + " nack");
            }
        });
        String msg = "Hello Fanout";
        // 这里即使加了routingKey，在fanout模式下也会被忽略
        channel.basicPublish(Constants.EXCHANGE_NAME, "test", null, msg.getBytes("UTF-8"));
        channel.waitForConfirmsOrDie(3000);
        System.out.println("Sent message: " + msg + " to exchange: " + channel.getChannelNumber());
    }
}
