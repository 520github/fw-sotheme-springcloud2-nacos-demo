package org.sunso.sotheme.springcloud.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sunso.sotheme.springcloud.common.data.DataDTO;
import org.sunso.sotheme.springcloud.user.entity.User;
import org.sunso.sotheme.springcloud.user.feign.DataFeignClient;
import org.sunso.sotheme.springcloud.user.service.UserService;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DataFeignClient dataFeignClient;

    @GetMapping("/get/{userId}")
    public User getOneByUserId(@PathVariable Long userId) {
        User user = userService.getOneByUserId(userId);
        log.info("get user[{}] by userId[{}]", user, userId);
        if (user == null) {
            user = new User();
            user.setId(-1L);
        }

        DataDTO dto = new DataDTO();
        dto.setServiceId("user");
        dto.setServiceName("userService");
        dto.setCreateDate(new Date());
        dataFeignClient.saveData(dto);
        return user;
    }
}
