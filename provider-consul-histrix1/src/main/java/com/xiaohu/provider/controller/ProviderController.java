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
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping("/timeout")
    public String timeout(){
        System.out.println("privider1 timeout执行");
        try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}

        return port;
    }

    /**
     * @Author ChenHu
     * @Date 2021/1/12 - 15:45
     * @Description @HystrixCommand注解fallbackMethod指定的兜底方法
     * @Return
     **/
    private String timeoutHandler(){
        System.out.println("timeoutHandler执行");
        return "请求超时，请稍后重试" + port;
    }

}
