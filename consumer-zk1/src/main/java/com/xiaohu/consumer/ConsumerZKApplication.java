package com.xiaohu.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ChenHu
 * @Date 2021/1/10 - 17:01
 * @Describe
 **/
@EnableDiscoveryClient //以后不管用什么注册中心，发现服务，都用这个注解
@SpringBootApplication(scanBasePackages = {"com.xiaohu.consumer","com.xiaohu.common"})
public class ConsumerZKApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerZKApplication.class,args);
    }
}
