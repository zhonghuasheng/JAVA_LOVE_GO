package com.springboot.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

public class BroadcastProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("defaultGroup");
        producer.setNamesrvAddr("rocketmq.host:9876");
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("TopicBroadcast", "TagA", "OrderID1099", "Hello Broadcast".getBytes(StandardCharsets.UTF_8));
            SendResult result = producer.send(msg);
            System.out.printf("%s%n", result);
        }
    }
}
