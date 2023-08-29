package org.sunso.sotheme.springcloud.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "gateway.filter")
public class FilterConfig {
    /**
     * 全局限流器每秒钟产生的令牌数
     */
    private double gloablRequestRateCount;
    private boolean verifyToken;

    public double getGloablRequestRateCount() {
        return gloablRequestRateCount;
    }

    public void setGloablRequestRateCount(double gloablRequestRateCount) {
        this.gloablRequestRateCount = gloablRequestRateCount;
    }

    public boolean isVerifyToken() {
        return verifyToken;
    }

    public void setVerifyToken(boolean verifyToken) {
        this.verifyToken = verifyToken;
    }
}
