package com.xiaohu.provider.config;

import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.model.UserInfo;
import com.xiaohu.provider.service.UserInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ChenHu
 * @Date 2021/4/8 - 10:23
 * @Describe
 **/
@Configuration
public class AutowiredConfig {

    @Bean
    public UserInfo myUser(UserInfoService userInfoService){

        ResponseObjectResult one = userInfoService.getOne(1);
        System.out.println("获取成功=========================>>>>" + one);

        return new UserInfo();
    }

}
