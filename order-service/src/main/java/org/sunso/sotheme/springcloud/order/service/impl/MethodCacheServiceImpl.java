package org.sunso.sotheme.springcloud.order.service.impl;

import org.springframework.stereotype.Service;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.enums.LocalCacheTypeEnum;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.method.annotation.MethodCache;
import org.sunso.sotheme.springcloud.order.entity.Order;

import java.util.Date;

@Service
public class MethodCacheServiceImpl {

    @MethodCache(localCacheType= LocalCacheTypeEnum.caffeine, bizPrefixKey = "methodCache", expireTime = 10*60)
    //@Override
    public Order getOrderByCaffeineLocalCache(Long orderId) {
        return getOrderById(orderId);
    }

    @MethodCache(localCacheType= LocalCacheTypeEnum.guava, bizPrefixKey = "methodCache", expireTime = 20*60)
    //@Override
    public Order getOrderByGuavaLocalCache(Long orderId) {
        return getOrderById(orderId);
    }

    private Order getOrderById(Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCreateTime(new Date());
        return order;
    }
}
