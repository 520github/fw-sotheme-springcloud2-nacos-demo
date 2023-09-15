package org.sunso.sotheme.springcloud.order.service.impl;

import org.springframework.stereotype.Service;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.enums.LocalCacheTypeEnum;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.method.annotation.MethodCache;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.multilevel.CustomMultiLevelCache;
import org.sunso.sotheme.springcloud.order.entity.Order;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class CustomCacheServiceImpl {

    @Resource
    private CustomMultiLevelCache customMultiLevelCache;

    //@Override
    public Order setOrderToLocalCache(String key, Long orderId, Long expireTime) {
        Order order = getOrderById(orderId);
        customMultiLevelCache.set(key, order, expireTime, TimeUnit.SECONDS);
        return getOrderById(orderId);
    }

    //@Override
    public Order getOrderByLocalCache(String key, Long expireTime) {
        return customMultiLevelCache.get(key, expireTime, TimeUnit.SECONDS, Order.class);
    }

    public int clear() {
        return customMultiLevelCache.clear();
    }

    private Order getOrderById(Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCreateTime(new Date());
        return order;
    }
}
