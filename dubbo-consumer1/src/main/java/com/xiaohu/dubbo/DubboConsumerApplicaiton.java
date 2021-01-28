package com.xiaohu.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ChenHu
 * @Date 2021/1/25 - 3:20
 * @Describe dubbo整合失败，原因不详。主要遇到了，两个问题
 * 1、feign依赖bean创建失败问题，导致项目启动失败（通过排除了feign的依赖解决）
 * 2、服务消费端，发现不了服务端的服务，始终显示地址不对（花了大量时间，遂放弃）
 * 总结，版本有问题，就不要死磕了，找一个和参照文档一样的环境，肯定能成功，
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class DubboConsumerApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplicaiton.class,args);
    }
}
