package com.zhonghuasheng.redis.service;

import com.zhonghuasheng.redis.config.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author ZHS
 */
@Slf4j
@Service
public class OrderService {

    @Autowired
    private RedisRepository redisRepository;

    /**
     * 下订单
     * @param goodsId 商品ID
     * @return
     */
    public boolean order(Integer goodsId) {
        String key = "order:" + goodsId;
        String requestId = goodsId + UUID.randomUUID().toString();
        boolean lock = redisRepository.lock(key, requestId, 10000);
        boolean result = false;
        try {
            if (lock) {
                long stock = redisRepository.decrement(String.valueOf(goodsId));
                if (stock > 0) {
                    log.info("剩余库存{}", stock);
                } else {
                    log.info("库存为0， {}", stock);
                }
                result = true;
            }
        } catch (Exception e) {
            log.error("下单异常，{}", e);
        } finally {
            redisRepository.unlockLua(String.valueOf(goodsId), requestId);
        }

        return result;
    }
}
