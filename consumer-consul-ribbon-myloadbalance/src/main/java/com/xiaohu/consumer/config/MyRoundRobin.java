package com.xiaohu.consumer.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author ChenHu
 * @Date 2021/1/12 - 0:06
 * @Describe 自定义负载均衡策略(轮询)
 *
 * 核心思想，请求次数和服务列表取模，算出来的就是服务实例的下标。获取服务实例
 *
 * 服务列表，由调用方法传入（使用DiscoveryClient discoveryClient; 获取）
 * 此处记录调用次数，并增加，算出下一个服务index，并返回服务实例
 *
 * 业务获取实例，进而得到，服务实际调用地址
 * ServiceInstance instance = myLoadBalance.getInstance(instances);
 * URI uri = instance.getUri();
 *
 * 需要RestTemplate,配置类，不使用@LoadBalanced。而是用，我自定义的
 *
 **/
@Component
public class MyRoundRobin implements MyLoadBalance {

    private static AtomicInteger requestCount = new AtomicInteger(0);

    /**
     * @Author ChenHu
     * @Date 2021/1/12 - 0:11
     * @Description 获取下个服务实例的下标
     * @Return
     **/
    private int increAndGetNext(){

        int expect;
        int next;
        do{
            expect= requestCount.get();
            next = expect >= Integer.MAX_VALUE ? 0 : expect+1;

        }while(!this.requestCount.compareAndSet(expect,next));

        System.out.println("=======next=========:" + next);
        return next;

    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {

        if(CollectionUtils.isEmpty(serviceInstances)){
            return null;
        }

        return serviceInstances.get(increAndGetNext() % serviceInstances.size());
    }
}
