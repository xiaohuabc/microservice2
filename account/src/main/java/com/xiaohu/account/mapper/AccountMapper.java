package com.xiaohu.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohu.model.account.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author ChenHu
 * @Date 2021/1/21 - 0:21
 * @Describe
 **/
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
