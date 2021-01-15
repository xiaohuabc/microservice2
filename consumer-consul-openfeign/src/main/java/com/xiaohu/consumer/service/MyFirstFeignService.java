package com.xiaohu.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ChenHu
 * @Date 2021/1/12 - 1:25
 * @Describe
 **/
@Service
@FeignClient("provider")
public interface MyFirstFeignService {

    @GetMapping("/provider/getMessage")
    String getMessage();

    @GetMapping("/provider/timeout")
    String timeout();

}
