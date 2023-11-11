package com.zhonghuasheng.rabbitmq.direct;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumers {
    private final static String EXCHANGE_NAME = "test.exchange.direct";
    public void receiveMessage(final String routingKey) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, routingKey);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                System.out.println("Routing Key is : " + routingKey + new String(body, "UTF-8"));
            }
        };
        channel.basicConsume(queueName, false, consumer);
    }
}
