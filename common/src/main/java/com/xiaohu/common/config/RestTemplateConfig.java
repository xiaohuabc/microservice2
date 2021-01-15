package com.xiaohu.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ChenHu
 * @Date 2021/1/10 - 16:13
 * @Describe
 **/
@Configuration
public class RestTemplateConfig {

    @Bean
//    @LoadBalanced // 如果是使用Feign客户端调用，默认用的就是Ribbon的负载均衡，可以不用此注解（如果没使用其他任务服务发现的组件，那么需要启用此注解）
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
