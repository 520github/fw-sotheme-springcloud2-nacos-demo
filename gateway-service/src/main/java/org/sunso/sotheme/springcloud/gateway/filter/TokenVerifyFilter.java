package org.sunso.sotheme.springcloud.gateway.filter;

import cn.hutool.core.util.StrUtil;
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

@Slf4j
@Service
public class TokenVerifyFilter implements GlobalFilter, Ordered {

    @Autowired
    private FilterConfig filterConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("TokenVerifyFilter do.......");
        if (filterConfig.isVerifyToken()) {
            String token = getToken(exchange);
            if (StrUtil.isBlank(token)) {
                return unAuthorized(exchange, chain, token);
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 5;
    }

    private String getToken(ServerWebExchange exchange) {
        return exchange.getRequest().getHeaders().getFirst("token");
    }

    private Mono<Void> unAuthorized(ServerWebExchange exchange, GatewayFilterChain chain, String token) {
        log.info("token[{}]认证未通过", token);
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);// 请求失败，返回请求太多
        return exchange.getResponse().setComplete();
    }
}
