package com.xiaohu.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author ChenHu
 * @Date 2021/1/10 - 19:03
 * @Describe
 **/
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Value("${rest.url.provider}")
    String providerUrl;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getPort")
    public String getPort(){
        return restTemplate.getForObject(providerUrl + "/provider/getPort",String.class);
    }


}
