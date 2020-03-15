package com.zhonghuasheng.seckill.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Bean
    public Queue queue() {
        return new Queue(MQSender.QUEUE_NAME, true); // queueName, durable是持久化
    }
}
