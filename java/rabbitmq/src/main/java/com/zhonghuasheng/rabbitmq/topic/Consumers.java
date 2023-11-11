package com.zhonghuasheng.rabbitmq.topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumers {

    public final static String EXCHANGE_NAME = "test.exchange.topic";

    public void receiveMessage(final String bindingKey) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String queueName = channel.queueDeclare().getQueue();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Routing Key is : " + bindingKey + " ---Message is: " + message);
            }
        };
        channel.basicConsume(queueName, false, consumer);
    }
}
