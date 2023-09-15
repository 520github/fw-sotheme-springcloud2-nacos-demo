package org.sunso.sotheme.springcloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.method.annotation.MethodCache;
import org.sunso.keypoint.springboot2.biz.keypoint.cache.multilevel.CustomMultiLevelCache;
import org.sunso.sotheme.springcloud.order.entity.Order;
import org.sunso.sotheme.springcloud.order.service.CacheService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Resource
    private CustomMultiLevelCache customMultiLevelCache;

    @Autowired
    private CacheService cacheService;

    @GetMapping("/order/redis/{orderId}")
    public Order getOrderByRedisOperate(@PathVariable Long orderId) {
        return cacheService.getOrderByRedisOperate(orderId);
    }


    @GetMapping("/string/{data}")
    @MethodCache
    public String getString(@PathVariable String data, HttpServletRequest request) {
        return data;
    }

    @GetMapping("/order/get/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        return cacheService.getOrder(orderId);
    }

    @GetMapping("/set/value/{key}/{value}")
    public String setValue(@PathVariable String key, @PathVariable String value) {
        customMultiLevelCache.set(key, value, 5*60, TimeUnit.SECONDS);
        return "set:"+key+":"+value;
    }

    @GetMapping("/get/value/{key}")
    public String getValue(@PathVariable String key) {
        return (String)customMultiLevelCache.get(key, 5*60, TimeUnit.SECONDS);
    }

    @GetMapping("/clear")
    public String clear() {
        customMultiLevelCache.clear();
        return "clear";
    }
}
