package com.xiaohu.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author ChenHu
 * @Date 2021/1/16 - 1:41
 * @Description 这个项目是失败了。我本以为，config-server服务端，包含了客户端的jar，可以直接引用服务端的依赖，就能完成客户端的功能
 * 后来试过多次，包括引入spring-cloud-context，依然无法使bootstrap.yml文件生效。自然无法加载到配置中心的配置
 * @Return
 **/
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
