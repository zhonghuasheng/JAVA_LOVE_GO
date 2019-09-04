package com.zhonghuasheng.rabbitmq.basic;

import com.rabbitmq.client.*;
import com.zhonghuasheng.rabbitmq.basic.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    private static final String QUEUE_NAME = "test.simple.queue";
    public void receiveMessage() {
        Connection connection = null;
        try {
            connection = ConnectionUtils.getConnection();
            Channel channel = connection.createChannel();
            DefaultConsumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(message);
                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
