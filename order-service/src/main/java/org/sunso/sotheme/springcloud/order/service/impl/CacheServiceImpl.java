package org.sunso.sotheme.springcloud.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.enums.LocalCacheTypeEnum;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.method.annotation.MethodCache;
import org.sunso.keypoint.springboot2.spring.redis.RedisOperate;
import org.sunso.sotheme.springcloud.order.entity.Order;
import org.sunso.sotheme.springcloud.order.service.CacheService;

import java.util.Date;

@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private RedisOperate redisOperate;

    public Order getOrderByRedisOperate(Long orderId) {
        Order order = getOrder(orderId);
        String key = "test_order_" + orderId;
        redisOperate.set(key, order);
        return redisOperate.get(key, Order.class);
    }


    @MethodCache(localCacheType=LocalCacheTypeEnum.caffeine, bizPrefixKey = "order", expireTime = 10*60)
    @Override
    public Order getOrder(Long orderId) {
        return getOrderById(orderId);
    }

    private Order getOrderById(Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCreateTime(new Date());
        return order;
    }
}
