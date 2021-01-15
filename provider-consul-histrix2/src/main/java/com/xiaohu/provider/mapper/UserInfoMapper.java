package com.xiaohu.provider.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohu.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author ChenHu
 * @Date 2020/5/26-15:08
 * @Describe
 **/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    int create(UserInfo userInfo);
}
