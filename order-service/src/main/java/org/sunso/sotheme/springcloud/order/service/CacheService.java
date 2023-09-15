package org.sunso.sotheme.springcloud.order.service;

import org.sunso.sotheme.springcloud.order.entity.Order;

public interface CacheService {

    Order getOrderByRedisOperate(Long orderId);

    Order getOrder(Long orderId);
}
