package com.zn.cloud.gateway.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author by zhaining
 * @description
 * @created date 2017/11/22.
 */
@Component
public class MyHealthChecker implements HealthIndicator
{
    private boolean up = true;

    @Override
    public Health health()
    {
        if (up) {
            //自定义监控内容
            return new Health.Builder().withDetail("aaa_cnt", 10)
                    .withDetail("bbb_status", "up").up().build();
        } else {
            return new Health.Builder().withDetail("error", "client is down").down().build();
        }
    }

    public boolean isUp()
    {
        return up;
    }

    public void setUp(boolean up)
    {
        this.up = up;
    }
}