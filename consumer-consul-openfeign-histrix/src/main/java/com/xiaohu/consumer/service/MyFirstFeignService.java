package com.xiaohu.consumer.service;

import com.xiaohu.consumer.service.callback.MyFallbackFactoryInstance;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ChenHu
 * @Date 2021/1/12 - 1:25
 * @Describe
 **/
@Component
//@FeignClient(name = "provider",fallback = MyFirstFeignServiceCallback.class)
@FeignClient(name = "provider",fallbackFactory = MyFallbackFactoryInstance.class)
public interface MyFirstFeignService {

    @GetMapping("/provider/getMessage")
    String getMessage();

    @GetMapping("/provider/timeout")
    String timeout();

}
