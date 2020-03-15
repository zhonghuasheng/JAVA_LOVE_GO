package com.zhonghuasheng.seckill.rabbitmq;

import com.zhonghuasheng.seckill.redis.RedisService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSender {

    public static final String QUEUE_NAME = "queue";

    @Autowired
    AmqpTemplate amqpTemplate;
    @Autowired
    RedisService redisService;

    public void send(Object message) {
        String msg = redisService.beanToString(message);
        System.out.println("sendmsg:" + msg);
        amqpTemplate.convertAndSend(QUEUE_NAME, msg);
    }
}
