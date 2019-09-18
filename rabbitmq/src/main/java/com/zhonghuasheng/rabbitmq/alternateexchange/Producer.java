package com.zhonghuasheng.rabbitmq.alternateexchange;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("backup.exchange", BuiltinExchangeType.FANOUT, true, false, null);
        // 声明一个正常的exchange和queue,并告诉exchange如果没有正确的路由则将消息放到backup-exchange中
        Map<String, Object> map = new HashMap<>();
        map.put("alternate-exchange", "backup.exchange");
        channel.exchangeDeclare("exchange_alternate_exchange", BuiltinExchangeType.DIRECT, true, false, map);
        channel.queueDeclare("queue_alternate_exchange", true, false, false, null);
        channel.queueBind("queue_alternate_exchange", "exchange_alternate_exchange", "key.alternate.exchange");

        // 给backup-exchange创建一个queue，用于存储
        channel.queueDeclare("unrouting_queue", true, false, false, null);
        channel.queueBind("unrouting_queue", "backup.exchange", "", null);

        String msg = "Hello alternate exchange";
        channel.basicPublish("exchange_alternate_exchange", "no-existed-routing-key", false, null, msg.getBytes());
    }
}
