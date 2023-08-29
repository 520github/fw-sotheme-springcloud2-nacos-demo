package org.sunso.sotheme.springcloud.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.sunso.sotheme.springcloud.common.user.UserDTO;

@FeignClient(url = "${feign.userService.url}") //url = "http://localhost:9092", name="userService"
public interface UserFeignClient {

    @GetMapping("/user/get/{userId}")
    UserDTO getOneByUserId(@PathVariable Long userId);
}
