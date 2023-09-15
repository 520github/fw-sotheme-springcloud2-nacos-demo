package org.sunso.sotheme.springcloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sunso.sotheme.springcloud.order.entity.Order;
import org.sunso.sotheme.springcloud.order.service.impl.CustomCacheServiceImpl;


@RestController
@RequestMapping("/cache/custom/")
public class CustomCacheController {

    @Autowired
    private CustomCacheServiceImpl customCacheService;

    @GetMapping("/set/value/{key}/{value}/{expireTime}")
    public Order setValue(@PathVariable String key, @PathVariable Long value, @PathVariable Long expireTime) {
        return customCacheService.setOrderToLocalCache(key, value, expireTime);
    }

    @GetMapping("/get/value/{key}/{expireTime}")
    public Order getValue(@PathVariable String key, @PathVariable Long expireTime) {
        return customCacheService.getOrderByLocalCache(key, expireTime);
    }

    @GetMapping("/clear")
    public String clear() {
        customCacheService.clear();
        return "clear";
    }
}
