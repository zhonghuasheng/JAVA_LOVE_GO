package com.springboot.rocketmq.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class AsyncProducer {

    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("defaultGroup");
        producer.setNamesrvAddr("nacos.host:9876");
        try {
            producer.start();
            producer.setRetryTimesWhenSendAsyncFailed(0);

            for (int i = 0; i < 100; i++) {
                final int index = i;
                String message = "Hello RocketMQ " + i;
                Message msg = new Message("TopicTest", "TagA", "OrderID201", message.getBytes(RemotingHelper.DEFAULT_CHARSET));
                producer.send(msg, new SendCallback() {
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        System.out.printf("%-10d OK %s %n", index, sendResult);
                    }

                    @Override
                    public void onException(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                });
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
            // The producer service state not OK, SHUTDOWN_ALREADY
            // 异步发送，注意shutdown不能过早，否则消息还未发出，producer就关闭了
            //producer.shutdown();
        }
    }
}
