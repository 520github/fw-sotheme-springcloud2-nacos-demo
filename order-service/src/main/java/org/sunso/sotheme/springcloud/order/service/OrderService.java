package org.sunso.sotheme.springcloud.order.service;

import org.sunso.sotheme.springcloud.order.entity.Order;

public interface OrderService {

    Order getOneByOrderId(Long orderId);
}
