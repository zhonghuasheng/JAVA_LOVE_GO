package com.zhonghuasheng.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BaseConsumer {

    @RabbitListener(queues = {"test_abc_1"})
    public void testAbc(String msg) {
        log.info("收到消息： {}", msg);
    }
}
