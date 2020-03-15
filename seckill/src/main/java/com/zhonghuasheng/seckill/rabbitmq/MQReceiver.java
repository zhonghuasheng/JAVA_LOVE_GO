package com.zhonghuasheng.seckill.rabbitmq;

import com.zhonghuasheng.seckill.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQReceiver.class);

    @Autowired
    AmqpTemplate amqpTemplate;
    @Autowired
    RedisService redisService;

    @RabbitListener(queues = MQSender.QUEUE_NAME)
    public void receive(String message) {
        String msg = redisService.beanToString(message);
        log.info(msg);
    }
}
