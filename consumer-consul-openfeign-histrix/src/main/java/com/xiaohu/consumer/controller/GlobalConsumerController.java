package com.xiaohu.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xiaohu.consumer.service.MyFirstFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenHu
 * @Date 2021/1/12 - 16:30
 * @Describe 全局降级处理
 **/
@DefaultProperties(defaultFallback = "globalFallbackHandler",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
})
@Slf4j
@RestController
@RequestMapping("/globalConsumer")
public class GlobalConsumerController {
    @Autowired
    MyFirstFeignService myFirstFeignService;

    @Value("${server.port}")
    String port;

    @HystrixCommand
    @GetMapping("/timeout")
    public String timeout(){
        return myFirstFeignService.timeout();
    }

    private String globalFallbackHandler(){
        return "全局兜底" + port;
    }
}
