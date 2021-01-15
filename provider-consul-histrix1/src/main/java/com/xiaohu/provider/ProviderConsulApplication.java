package com.xiaohu.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.xiaohu.provider","com.xiaohu.common"})
public class ProviderConsulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderConsulApplication.class, args);
    }

}
