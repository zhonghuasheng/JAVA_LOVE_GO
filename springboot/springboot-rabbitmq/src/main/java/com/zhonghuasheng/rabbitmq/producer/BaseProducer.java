package com.zhonghuasheng.rabbitmq.producer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mqp")
public class BaseProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/produce")
    public void produce() {
        JSONObject message = new JSONObject();
        message.put("name", "test_abc");
        // test_abc这个exchange下有3个queue，均未设置routing key，这时候发送一条消息，三个queue都收到了
        rabbitTemplate.convertAndSend("test_abc", null, message.toJSONString());
        rabbitTemplate.convertAndSend("test_abc", null, message.toJSONString());
    }
}
