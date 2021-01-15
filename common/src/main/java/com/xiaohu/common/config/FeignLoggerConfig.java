package com.xiaohu.common.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ChenHu
 * @Date 2021/1/12 - 2:14
 * @Describe
 **/
@Configuration
public class FeignLoggerConfig {

    @Bean
    Logger.Level getFeignLogLevel(){
        return Logger.Level.FULL;
    }
}
