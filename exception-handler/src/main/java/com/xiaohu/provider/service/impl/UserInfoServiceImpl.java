package com.xiaohu.provider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.common.response.ResponseStatus;
import com.xiaohu.model.UserInfo;
import com.xiaohu.provider.mapper.UserInfoMapper;
import com.xiaohu.provider.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ChenHu
 * @Date 2020/5/26-15:09
 * @Describe
 **/
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;


    @Override
    public ResponseObjectResult getAll() {
        return new ResponseObjectResult(ResponseStatus.responseSuccess(),userInfoMapper.selectList(null));
    }

    @Override
    public ResponseObjectResult insert(UserInfo userInfo) {

        userInfoMapper.insert(userInfo);
        return new ResponseObjectResult(ResponseStatus.responseSuccess());
    }

    @Override
    public ResponseObjectResult create(UserInfo userInfo) {

        int rows = userInfoMapper.create(userInfo);
        if(rows > 0){
            return ResponseObjectResult.responseSuccess();
        }

        return ResponseObjectResult.responseFail();
    }

    @Override
    public ResponseObjectResult getOne(Integer id) {

        List<UserInfo> list = userInfoMapper.selectList(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getId, id));

        return new ResponseObjectResult(ResponseStatus.responseSuccess(),list);
    }
}
