package org.sunso.sotheme.springcloud.order.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDTO {
    private Long orderId;
    private Date createTime;
    private UserDTO user;

    public static OrderDTO newInstance(Long orderId) {
        OrderDTO instance = new OrderDTO();
        instance.setOrderId(orderId);
        instance.setCreateTime(new Date());
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(orderId-1);
        userDTO.setUserName(userDTO.getUserId() + "-name");
        instance.setUser(userDTO);
        return instance;
    }
}
