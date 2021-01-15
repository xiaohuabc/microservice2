package com.xiaohu.consumer.config;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author ChenHu
 * @Date 2021/1/12 - 0:05
 * @Describe
 **/
public interface MyLoadBalance {

    ServiceInstance getInstance(List<ServiceInstance> serviceInstances);

}
