package org.sunso.sotheme.springcloud.user.config;

import feign.Logger;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Bean
    public Logger logger() {
        return new Slf4jLogger();
    }
}
