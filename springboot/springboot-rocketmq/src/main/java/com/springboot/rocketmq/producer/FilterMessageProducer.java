package com.springboot.rocketmq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

import java.nio.charset.StandardCharsets;

public class FilterMessageProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("defaultGroup");
        producer.setNamesrvAddr("rocketmq.host:9876");
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message msg = new Message("TopicFilters", "tag1", ("Hello " + i).getBytes(StandardCharsets.UTF_8));
            msg.putUserProperty("a", String.valueOf(i));
            producer.send(msg);
            System.out.println(i);
        }
        System.out.println("start");
    }
}
