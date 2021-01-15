package com.xiaohu.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author ChenHu
 * @Date 2021/1/10 - 17:01
 * @Describe
 **/
@EnableEurekaClient
@SpringBootApplication(scanBasePackages = {"com.xiaohu.consumer","com.xiaohu.common"})
public class Consumer2Application {
    public static void main(String[] args) {
        SpringApplication.run(Consumer2Application.class,args);
    }
}
