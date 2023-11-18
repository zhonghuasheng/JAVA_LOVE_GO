package com.springboot.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class SyncProducer {

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("defaultGroup");
        producer.setNamesrvAddr("nacos.host:9876");
        try {
            producer.start();
            for (int i = 0; i < 100; i++) {
                String message = "Hello Rocket " + i;
                Message msg = new Message("demo", "TagA", message.getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = producer.send(msg);
                System.out.printf("%s%n", sendResult);
            }
        } catch (MQClientException | UnsupportedEncodingException | RemotingException | MQBrokerException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            producer.shutdown();
        }
    }
}
