package com.xiaohu.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiaohu.common.exception.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenHu
 * @Date 2021/1/12 - 20:42
 * @Describe 服务熔断接口
 **/
@RestController
@RequestMapping("/breaker")
public class ServiceBreakerController {

    @Value("${server.port}")
    String port;

    @HystrixCommand(fallbackMethod = "breakServiceHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "40")//失败率达到多少后跳闸
    })
    //合起来是10秒内，请求10次，失败率达到60%就跳闸
    @GetMapping("/breakService/{num}")
    public String breakService(@PathVariable("num") Integer num){
        System.out.println("路径变量，请求成功:" + num);

        if(num > 5){
            throw new MyException("数据错误");
        }

        return "HelloWorld!";
    }

    /**
     * @Author ChenHu
     * @Date 2021/1/12 - 20:59
     * @Description 熔断处理方法：参数要一致，否则找不到熔断处理方法
     * @Return
     **/
    public String breakServiceHandler(Integer num){
        System.out.println("参数要一致，否则找不到熔断处理方法：" + num);
        System.out.println("触发熔断:" + port);

        return "触发熔断!" + port;
    }


}
