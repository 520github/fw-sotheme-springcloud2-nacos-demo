package org.sunso.sotheme.springcloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sunso.sotheme.springcloud.order.entity.Order;
import org.sunso.sotheme.springcloud.order.service.impl.MethodCacheServiceImpl;

@Slf4j
@RestController
@RequestMapping("/cache/method")
public class OrderMethodCacheController {

    @Autowired
    private MethodCacheServiceImpl methodCacheService;

    @GetMapping("/order/caffeine/get/{orderId}")
    public Order getOrderByCaffeineLocalCache(@PathVariable Long orderId) {
        log.info("getOrderByCaffeineLocalCache orderId[{}]", orderId);
        return methodCacheService.getOrderByCaffeineLocalCache(orderId);
    }

    @GetMapping("/order/guava/get/{orderId}")
    public Order getOrderByGuavaLocalCache(@PathVariable Long orderId) {
        return methodCacheService.getOrderByGuavaLocalCache(orderId);
    }
}
