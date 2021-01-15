package com.xiaohu.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/timeout")
    public String timeout(){
//        try {TimeUnit.SECONDS.sleep(2);} catch (InterruptedException e) {e.printStackTrace();}

        return port;
    }
}
