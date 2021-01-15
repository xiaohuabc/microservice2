package com.xiaohu.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ChenHu
 * @Date 2021/1/13 - 18:15
 * @Describe
 **/
@Component
@FeignClient("provider")
public interface ProviderServie {

    @GetMapping("/provider/getPort")
    public String getPort();

}
