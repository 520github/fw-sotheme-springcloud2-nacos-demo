package org.sunso.sotheme.springcloud.gateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import org.sunso.sotheme.springcloud.gateway.config.FilterConfig;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class RequestRateLimiterFilter implements GlobalFilter, Ordered {

    @Autowired
    private FilterConfig filterConfig;

    private RateLimiter globalRateLimiter;

    @PostConstruct
    public void init() {
        globalRateLimiter = RateLimiter.create(filterConfig.getGloablRequestRateCount());
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("RequestRateLimiterFilter do.......");
        if (!globalRateLimiter.tryAcquire(1, TimeUnit.SECONDS) ) {
            return tooManyRequest(exchange, chain);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 10;
    }

    private Mono<Void> tooManyRequest(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("每秒请求数超过[{}]，触发限流", filterConfig.getGloablRequestRateCount());
        exchange.getResponse().setStatusCode(HttpStatus.TOO_MANY_REQUESTS);// 请求失败，返回请求太多
        return exchange.getResponse().setComplete();
    }
}
