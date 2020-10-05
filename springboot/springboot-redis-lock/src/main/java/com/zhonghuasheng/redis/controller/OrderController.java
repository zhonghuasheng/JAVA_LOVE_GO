package com.zhonghuasheng.redis.controller;

import com.zhonghuasheng.redis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{goodsId}")
    public String order(@PathVariable("goodsId") Integer goodsId) {
        boolean order = orderService.order(goodsId);
        String result = order ? "下单成功" : "下单失败";
        return result;
    }
}
