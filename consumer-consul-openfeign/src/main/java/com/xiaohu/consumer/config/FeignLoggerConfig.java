package com.xiaohu.consumer.config;

import feign.Logger;

/**
 * @Author ChenHu
 * @Date 2021/1/12 - 2:14
 * @Describe 此配置已提取到，公共common模块（因为后期的开发，都准备使用OpenFeign做服务调用）
 **/
//@Configuration
public class FeignLoggerConfig {

//    @Bean
    Logger.Level getFeignLogLevel(){
        return Logger.Level.FULL;
    }
}
