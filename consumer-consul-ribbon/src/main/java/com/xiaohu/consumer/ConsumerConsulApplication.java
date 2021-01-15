package com.xiaohu.consumer;

import com.xiaohu.outconfig.MyLoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author ChenHu
 * @Date 2021/1/10 - 17:01
 * @Describe
 **/
@RibbonClient(name = "provider", configuration = MyLoadBalanceConfig.class)
@EnableDiscoveryClient //以后不管用什么注册中心，发现服务，都用这个注解
@SpringBootApplication(scanBasePackages = {"com.xiaohu.consumer","com.xiaohu.common"})
public class ConsumerConsulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulApplication.class,args);
    }
}
