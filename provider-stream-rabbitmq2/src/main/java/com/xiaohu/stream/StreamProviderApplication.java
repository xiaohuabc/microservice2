package com.xiaohu.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ChenHu
 * @Date 2021/1/17 - 16:25
 * @Describe
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class StreamProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamProviderApplication.class,args);
    }
}
