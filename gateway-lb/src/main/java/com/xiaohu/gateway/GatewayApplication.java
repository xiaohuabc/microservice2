package com.xiaohu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ChenHu
 * @Date 2021/1/15 - 14:42
 * @Describe 使用Nacos作为注册中心，OpenFeign做接口调用，Gateway做网关配置
 * Sentinel做网关和应用实例的限流
 *
 * 使用spring-cloud-starter-gateway,不需要引入spring-cloud-starter-wab模块
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class,args);
    }
}
