package org.sunso.sotheme.springcloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.manager.RedisAndCaffeineMultiLevelCache;
import org.sunso.sotheme.springcloud.order.entity.Order;
import org.sunso.sotheme.springcloud.order.service.CacheService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Resource
    private RedisAndCaffeineMultiLevelCache redisAndCaffeineMultiLevelCache;

    @Autowired
    private CacheService cacheService;

    @GetMapping("/order/get/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        return cacheService.getOrder(orderId);
    }

    @GetMapping("/set/value/{key}/{value}")
    public String setValue(@PathVariable String key, @PathVariable String value) {
        redisAndCaffeineMultiLevelCache.put(key, value);
        return "set:"+key+":"+value;
    }

    @GetMapping("/get/value/{key}")
    public String getValue(@PathVariable String key) {
        return (String)redisAndCaffeineMultiLevelCache.get(key).get();
    }

    @GetMapping("/clear")
    public String clear() {
        redisAndCaffeineMultiLevelCache.clear();
        return "clear";
    }
}
