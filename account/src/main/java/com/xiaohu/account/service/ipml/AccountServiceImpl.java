package com.xiaohu.account.service.ipml;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaohu.account.mapper.AccountMapper;
import com.xiaohu.account.service.AccountService;
import com.xiaohu.model.account.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author ChenHu
 * @Date 2021/1/20 - 23:34
 * @Describe
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountMapper accountMapper;

    /**
     * @Author ChenHu
     * @Date 2021/1/20 - 23:36
     * @Description 扣减余额
     * @Return
     **/
    @Override
    public void decreMoney(Account account) {

        Account user = accountMapper.selectOne(new LambdaQueryWrapper<Account>().eq(Account::getUserId, account.getUserId()));
        account.setMoney(user.getMoney().subtract(account.getDiscount()));

        accountMapper.update(account,new LambdaQueryWrapper<Account>().eq(Account::getUserId,account.getUserId()));

    }
}
