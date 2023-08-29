package org.sunso.sotheme.springcloud.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.sunso.sotheme.springcloud.common.data.DataDTO;

@FeignClient("dataService")
public interface DataFeignClient {

    @PostMapping("/data/save")
    int saveData(@RequestBody DataDTO dto);
}

