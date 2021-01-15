package com.xiaohu.consumer.service.callback;

import com.xiaohu.consumer.service.MyFirstFeignService;
import org.springframework.stereotype.Component;

/**
 * @Author ChenHu
 * @Date 2021/1/12 - 16:58
 * @Describe 继承外部接口MyFirstFeignService的方式，完成服务降级
 **/
@Component
public class MyFirstFeignServiceCallback implements MyFirstFeignService {

    public MyFirstFeignServiceCallback(){
        System.out.println("========================MyFirstFeignService实例化");
    }

    @Override
    public String getMessage() {
        System.out.println("getMessage全局处理============执行");
        return "getMessage全局处理";
    }

    @Override
    public String timeout() {
        System.out.println("timeout全局处理====================执行");
        return "timeout全局处理";
    }
}
