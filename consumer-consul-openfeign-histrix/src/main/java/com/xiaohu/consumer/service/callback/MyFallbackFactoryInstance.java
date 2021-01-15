package com.xiaohu.consumer.service.callback;

import com.xiaohu.consumer.service.MyFirstFeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author ChenHu
 * @Date 2021/1/12 - 18:39
 * @Describe 实现FallbackFactory的方式，完成服务降级
 **/
@Component
public class MyFallbackFactoryInstance implements FallbackFactory<MyFirstFeignService> {

    @Override
    public MyFirstFeignService create(Throwable throwable) {
        return new MyFirstFeignService(){

            @Override
            public String getMessage() {
                return "工厂方法getMessage";
            }

            @Override
            public String timeout() {
                return "工厂方法timeout";
            }
        };
    }

}
