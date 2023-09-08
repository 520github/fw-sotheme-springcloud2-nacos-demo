package org.sunso.sotheme.springcloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sunso.sotheme.springcloud.common.data.DataDTO;
import org.sunso.sotheme.springcloud.common.user.UserDTO;
import org.sunso.sotheme.springcloud.order.entity.Order;
import org.sunso.sotheme.springcloud.order.feign.DataFeignClient;
import org.sunso.sotheme.springcloud.order.feign.UserFeignClient;
import org.sunso.sotheme.springcloud.order.service.OrderService;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private DataFeignClient dataFeignClient;

    @GetMapping("/test/async/{time}")
    public long testAsync(@PathVariable long time) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("testAsync time[{}]", time);
            }
        });
        thread.start();
        return time;
    }

    @GetMapping("/get/{orderId}")
    @ResponseBody
    public Order getOneByOrderId(@PathVariable Long orderId) {
        Order order = orderService.getOneByOrderId(orderId);
        log.info("get order[{}] by orderId[{}]", order, orderId);
        if (order == null) {
            order = new Order();
            order.setOrderId(-1L);
            return order;
        }
        DataDTO dto = new DataDTO();
        dto.setServiceId("order");
        dto.setServiceName("orderService");
        dto.setCreateDate(new Date());
        dataFeignClient.saveData(dto);
        return order;
    }

    @GetMapping("/user/get/{userId}")
    public UserDTO getOneUserByUserId(@PathVariable Long userId) {
        return userFeignClient.getOneByUserId(userId);
    }

}
