package com.xiaohu.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenHu
 * @Date 2021/1/16 - 1:01
 * @Describe
 **/
@RefreshScope
@RequestMapping("/port")
@RestController
public class PortController {

    @Value("${server.port}")
    String port;

    @Value(("${info.version}"))
    String version;

    @GetMapping("/getPort")
    public String getPort(){
        return port;
    }

    @GetMapping("/getVersion")
    public String getVersion(){
        return version;
    }


}
