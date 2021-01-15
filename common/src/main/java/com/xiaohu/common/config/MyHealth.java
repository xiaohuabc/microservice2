package com.xiaohu.common.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @Author ChenHu
 * @Date 2021/1/9 - 14:46
 * @Describe 自定义健康监控信息
 * 默认看不到details详情。需要配置management.endpoint.health.show-details: always
 **/
@Component
public class MyHealth implements HealthIndicator {

    //往健康详情details里面加个属性
    @Override
    public Health health() {
        return Health.up().withDetail("hello","chenhu").build();
    }
}
