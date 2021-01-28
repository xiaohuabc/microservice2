package com.xiaohu.dubbo.service.dubbo;

import com.xiaohu.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author ChenHu
 * @Date 2021/1/25 - 2:47
 * @Describe
 **/

//在同包下， @Service的替代，应该就是@DubboService了
//@Reference的替代，应该也是@DubboReference
@DubboService
//@Service
public class HelloServiceImpl implements HelloService {

    @Value("${server.port}")
    String port;

    @Override
    public String getPort() {
        return port;
    }
}
