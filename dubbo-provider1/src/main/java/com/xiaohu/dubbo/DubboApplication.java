package com.xiaohu.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ChenHu
 * @Date 2021/1/25 - 2:53
 * @Describe
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class DubboApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboApplication.class,args);
    }
}
