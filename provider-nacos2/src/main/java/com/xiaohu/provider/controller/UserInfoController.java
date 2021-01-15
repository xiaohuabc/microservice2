package com.xiaohu.provider.controller;

import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.model.UserInfo;
import com.xiaohu.provider.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author ChenHu
 * @Date 2020/5/26-15:03
 * @Describe
 **/
@Slf4j
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/insert")
    public ResponseObjectResult insert(@Valid @RequestBody UserInfo userInfo){

        return userInfoService.insert(userInfo);

    }

    @PostMapping("/getOne")
    public ResponseObjectResult getOne(@Param("id") Integer id){

        return userInfoService.getOne(id);

    }

    @PostMapping("/create")
    public ResponseObjectResult create(@RequestBody(required = false) UserInfo userInfo){

        return userInfoService.create(userInfo);

    }



}
