package org.sunso.sotheme.springcloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.sunso.keypoint.springboot2.common.exception.BizRuntimeException;
import org.sunso.keypoint.springboot2.common.status.ResultStatusEnumInterface;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
//@Controller
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/test")
    //@ResponseBody
    public String testDemo() {
        return "demo:" ;
    }

    @GetMapping("/exception/biz/{tag}")
    public String bizException(@PathVariable String tag) {
        if ("error".equalsIgnoreCase(tag)) {
            throw new BizRuntimeException(ResultStatusEnumInterface.valueOf("error", "测试异常"));
        }
        return tag;
    }

    @GetMapping("/go/{target}")
    public void go(@PathVariable String target, HttpServletResponse response) {
        try {
            String url = "https://github.com/520github?tab=repositories";
            if ("baidu".equalsIgnoreCase(target)) {
                url = "http://www.baidu.com";
            }
            response.sendRedirect(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
