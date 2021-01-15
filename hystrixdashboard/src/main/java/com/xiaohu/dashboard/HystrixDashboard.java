package com.xiaohu.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author ChenHu
 * @Date 2021/1/13 - 1:09
 * @Describe
 **/
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard.class,args);
    }

}
