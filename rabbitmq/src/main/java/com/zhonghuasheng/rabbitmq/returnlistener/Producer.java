package com.zhonghuasheng.rabbitmq.returnlistener;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Luke
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();
        String exchangeName = "test.exchange.returnlistener1";
        String msg = "This is test for return listener";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC, true, false, null);

        /**
         *
         * ReturnListener用于处理一些不可路由的消息。如果我们在发送消息的时候，当前的exchange不存在或者制定的路由key路由不到，
         * 这个时候如果我们需要监听这种不可达的消息，就要使用return listener。
         */
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("This message comes from ReturnListener#handleReturn");
                System.out.println("======= handle ======= return ========");
                System.out.println("replyCode: " + replyCode);
                System.out.println("replyText: " + replyText);
                System.out.println("exchange: " + exchange);
                System.out.println("routingKey: " + routingKey);
                System.out.println("properties: " + properties);
            }
        });

        // channel.basicPublish(exchangeName, "exchange.returnlistener", true, null, msg.getBytes());

        // mandatory设置为true：监听器会接收到路由不可达的消息; 设置为false： broker端自动删除该消息。
        channel.basicPublish(exchangeName, "return.error.key1", true, null, msg.getBytes());
    }
}
