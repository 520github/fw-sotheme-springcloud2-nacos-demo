package org.sunso.sotheme.springcloud.order.service.impl;

import org.springframework.stereotype.Service;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.annotation.MethodCache;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.enums.LocalCacheTypeEnum;
import org.sunso.sotheme.springcloud.order.entity.Order;
import org.sunso.sotheme.springcloud.order.service.CacheService;

import java.util.Date;

@Service
public class CacheServiceImpl implements CacheService {

    @MethodCache(localCacheType=LocalCacheTypeEnum.empty)
    @Override
    public Order getOrder(Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCreateTime(new Date());
        return order;
    }
}
