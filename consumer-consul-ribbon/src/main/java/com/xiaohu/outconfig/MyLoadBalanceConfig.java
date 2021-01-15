package com.xiaohu.outconfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ChenHu
 * @Date 2021/1/11 - 23:16
 * @Describe 自定义轮询策略为随机。
 * 定义在main启动类所在包外，如果被@component扫描到，那么这个配置对所有服务访问生效
 *
 * 主启动类，使用注解@RibbonClient(name = "provider", configuration = MyLoadBalanceConfig.class)
 * 指明，provider服务，使用MyLoadBalanceConfig.class配置类，定义的负载均衡策略。其他服务，不受影响，使用默认的负载均衡策略
 **/
@Configuration
public class MyLoadBalanceConfig {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
