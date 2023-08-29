package org.sunso.sotheme.springcloud.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sunso.sotheme.springcloud.order.entity.Order;
import org.sunso.sotheme.springcloud.order.mapper.OrderMapper;
import org.sunso.sotheme.springcloud.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getOneByOrderId(Long orderId) {
        Order order = orderMapper.getOneByOrderId(orderId);
        return order;
    }
}
