package com.zhonghuasheng.redis.service;

import com.zhonghuasheng.redis.config.RedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Luke
 */
@Slf4j
@Service
public class OrderService {

    @Autowired
    private RedisRepository redisRepository;
    @Autowired
    private RedissonClient redissonClient;

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
                int stock = redisRepository.decrement(String.valueOf(goodsId));
                if (stock > 0) {
                    log.info("剩余库存{}", stock);
                } else {
                    log.info("库存为0， {}", stock);
                }
                result = true;
            } else {
                log.info("没获取到锁");
            }
        } catch (Exception e) {
            log.error("下单异常，{}", e);
        } finally {
            redisRepository.unlockLua(String.valueOf(goodsId), requestId);
        }

        return result;
    }

    /**
     * 使用RedLock实现分布式锁
     * @param goodsId 商品ID
     * @return
     */
    public boolean order2(Integer goodsId) {
        boolean result = false;
        RLock lock = redissonClient.getLock("order:" + goodsId);
        try {
            boolean locked = lock.tryLock(2, 5, TimeUnit.SECONDS);
            if (locked) {
                int stock = redisRepository.decrement(String.valueOf(goodsId));
                if (stock > 0) {
                    log.info("剩余库存{}", stock);
                } else {
                    log.info("库存为0， {}", stock);
                }
                result = true;
            } else {
                log.warn("获取分布式锁失败");
            }
        } catch (Exception e) {
            log.info("获取分布式锁失败, {}", e);
        } finally {
            if (lock.isLocked()) {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }

        return result;
    }
}
