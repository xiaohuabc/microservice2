package com.xiaohu.consumer.controller;

import com.xiaohu.consumer.service.ProviderServie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author ChenHu
 * @Date 2021/1/10 - 19:03
 * @Describe
 **/
@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    ProviderServie providerServie;

    @GetMapping("/getPort")
    public String getPort(){
        return providerServie.getPort();
    }



}
