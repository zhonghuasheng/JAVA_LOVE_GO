package com.springboot.rocketmq.producer;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class OnewayProducer {

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("defaultGroup");
        producer.setNamesrvAddr("nacos.host:9876");
        try {
            producer.start();
            for (int i = 0; i < 100; i++) {
                String message = "Hello World " + i;
                Message msg = new Message("TopicTestB", "TagB", message.getBytes(RemotingHelper.DEFAULT_CHARSET));
                producer.sendOneway(msg);
            }
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // producer.shutdown();
        }
    }
}
