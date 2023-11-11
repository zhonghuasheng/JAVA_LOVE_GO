package com.springboot.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class OrderProducer {

    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("defaultGroup");
        producer.setNamesrvAddr("rocketmq.host:9876");
        String[] tags = new String[] {"Tag1", "Tag2", "Tag3", "Tag4", "Tag5"};
        producer.start();

        for (int i = 0; i < 100; i++) {
            int orderId = i % 10;
            Message msg = new Message("TopicOrder", tags[i % tags.length], ("Hello Order Message " + i).getBytes(StandardCharsets.UTF_8));
            SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message message, Object arg) {
                    Integer id = (Integer) arg;
                    int index = id % mqs.size();
                    return mqs.get(index);
                }
            }, orderId);
            System.out.printf("%s%n", sendResult);
        }
    }
}
