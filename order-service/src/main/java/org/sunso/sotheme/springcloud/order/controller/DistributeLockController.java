package org.sunso.sotheme.springcloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sunso.sotheme.springcloud.order.dto.OrderDTO;
import org.sunso.sotheme.springcloud.order.entity.Order;
import org.sunso.sotheme.springcloud.order.service.impl.DistributeLockServiceImpl;

import java.util.Date;

@RestController
@RequestMapping("/distribute/lock")
public class DistributeLockController {

    @Autowired
    private DistributeLockServiceImpl distributeLockService;

    @GetMapping("/aspect/{orderId}")
    public OrderDTO aspect(@PathVariable Long orderId) {
        return distributeLockService.aspect(OrderDTO.newInstance(orderId));
    }


    @GetMapping("/test")
    public String test() {
        return distributeLockService.methodLock();
    }

    @GetMapping("/timeout/{timeout}")
    public long timeoutLock(@PathVariable long timeout) {
        return distributeLockService.getTimeoutLock(timeout);
    }
}
