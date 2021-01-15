package com.xiaohu.provider.service;


import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.model.UserInfo;

/**
 * @Author ChenHu
 * @Date 2020/5/26-15:09
 * @Describe
 **/
public interface UserInfoService {

    ResponseObjectResult insert(UserInfo userInfo);

    ResponseObjectResult create(UserInfo userInfo);

    ResponseObjectResult getOne(Integer id);
}
