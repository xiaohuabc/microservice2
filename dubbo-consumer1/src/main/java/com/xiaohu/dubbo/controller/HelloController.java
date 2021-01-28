package com.xiaohu.dubbo.controller;

import com.xiaohu.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenHu
 * @Date 2021/1/25 - 3:21
 * @Describe
 **/
@RequestMapping("/hello")
@RestController
public class HelloController {

//    @Reference
    @DubboReference
    HelloService helloService;

    @GetMapping("/getPort")
    public String getPort(){
        return helloService.getPort();
    }

}
