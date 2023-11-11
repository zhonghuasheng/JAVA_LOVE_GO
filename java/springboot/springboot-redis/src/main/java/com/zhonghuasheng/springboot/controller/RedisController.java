package com.zhonghuasheng.springboot.controller;

import com.zhonghuasheng.springboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @PostMapping("/set/{key}/{value}")
    public String set(@PathVariable("key") String key, @PathVariable("value") String value) {
        boolean set = redisService.set(key, value);
        return "Set Finished";
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key) {
        return redisService.get(key);
    }

    @GetMapping("/")
    public String index() {
        return redisService.get("hello");
    }

    @GetMapping("/fatal")
    public void masterFatal() {
        int counter = 0;
        while (true) {
            Jedis jedis = null;
            try {
                jedis = redisService.getJedis();
                int index = new Random().nextInt(100000);
                String key = "k1:" + index;
                String value = "v:" + index;
                jedis.set(key, value);
                System.out.println(key + "    " + value);
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }
    }
}
