package com.springboot.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

public class DelayMessageProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("defaultGroup");
        producer.setNamesrvAddr("rocketmq.host:9876");
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message message = new Message("TopicDelay", ("Hello Delay Message " + i).getBytes(StandardCharsets.UTF_8));
            message.setDelayTimeLevel(3);
            SendResult send = producer.send(message);
            System.out.println(i);
        }
    }
}
