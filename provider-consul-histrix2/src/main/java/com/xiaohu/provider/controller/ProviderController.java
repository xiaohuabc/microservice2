package com.xiaohu.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author ChenHu
 * @Date 2021/1/10 - 18:53
 * @Describe
 **/
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Value("${info.name}")
    String info;

    @Value("${server.port}")
    String port;

    @GetMapping("/getMessage")
    public String getMessage(){
        return info;
    }

    @GetMapping("/getPort")
    public String getPort(){
        return port;
    }

    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {
            //指定方法执行超时时间
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping("/timeout")
    public String timeout(){
        System.out.println("privider1 timeout执行");
        //@HystrixCommand对异常具有服务降级功能。
        //其他的降级条件，需要在@HystrixProperty指定。
        //可选HystrixProperty在HystrixPropertiesManager指定
//        int i = 1/0;
        System.out.println("timeout执行" + port);
        try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}

        return port;
    }

    private String timeoutHandler(){
        System.out.println("timeoutHandler执行");
        return "请求超时，请稍后重试" + port;
    }
}
