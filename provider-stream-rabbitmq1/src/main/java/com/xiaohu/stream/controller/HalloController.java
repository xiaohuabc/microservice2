package com.xiaohu.stream.controller;

import com.xiaohu.stream.message.consumer.HelloMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ChenHu
 * @Date 2021/1/17 - 16:47
 * @Describe
 **/
@RequestMapping("/hello")
@RestController
public class HalloController {

    @Resource
    HelloMessage helloMessage;

    @GetMapping("/sayHello")
    public String sayHello(){
        return helloMessage.sayHallo();
    }
}
