package com.xiaohu.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ChenHu
 * @Date 2021/1/20 - 23:33
 * @Describe
 **/
@EnableDiscoveryClient
@MapperScan({"com.xiaohu.account.mapper"})
@SpringBootApplication(scanBasePackages = {"com.xiaohu.account","com.xiaohu.common"})//取消数据源自动创建的配置
public class AccountApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(AccountApplicaiton.class,args);
    }
}
