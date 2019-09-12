package com.zhonghuasheng.rabbitmq.message;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

/**
 * @author Luke
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("test.message", true, false, false, null);
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                      Envelope envelope,
                                      AMQP.BasicProperties properties,
                                      byte[] body)
                    throws IOException {
                String msg = new String(body);
                Map<String, Object> headers = properties.getHeaders();
                Set<Map.Entry<String, Object>> entries = headers.entrySet();
                for (Map.Entry entry : entries) {
                    System.out.println(entry.getKey() + " : " + entry.getValue());
                }
                System.out.println(msg);
            }
        };
        channel.basicConsume("test.message", true, consumer);
    }
}
