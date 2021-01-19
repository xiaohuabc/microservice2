package com.xiaohu.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenHu
 * @Date 2021/1/18 - 16:46
 * @Describe
 **/
@RefreshScope
@RequestMapping("/config")
@RestController
public class ConfigController {

    @Value("${info.version}")
    String version;

    @GetMapping("/getVersion")
    public String getVersion(){
        return version;
    }

}
