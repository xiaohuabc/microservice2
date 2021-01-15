package com.xiaohu.provider.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xiaohu.provider.blockhandler.GlobalBlockHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

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

    @SentinelResource(value = "myKey",blockHandler = "blockMethod",fallback = "fallbackMethod")
    @GetMapping("/myKey")
    public String myKey(@RequestParam(required = false) String key1,@RequestParam(required = false) String key2){

        if(key2 != null){
            int i = 20/0;
        }
        return port;
    }

    public String blockMethod(String key1,String key2,BlockException blockException){
        return "blockMethod";
    }

    public String fallbackMethod(String key1,String key2){
        System.out.println("key1:" + key1 + "----key2:" + key2);
        return "fallbackMethod";
    }

    @SentinelResource(value = "globalHandler",blockHandlerClass = GlobalBlockHandler.class,blockHandler = "block2")
    @GetMapping("/globalHandler")
    public String globalHandler(){
        return port;
    }






}
