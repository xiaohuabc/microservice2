package com.xiaohu.account.controller;

import com.xiaohu.account.service.AccountService;
import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.common.response.ResponseStatus;
import com.xiaohu.model.account.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenHu
 * @Date 2021/1/20 - 23:34
 * @Describe
 **/
@RequestMapping("/account")
@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/discount")
    public ResponseObjectResult discount(@RequestBody Account account){
        accountService.decreMoney(account);

        return new ResponseObjectResult(ResponseStatus.responseSuccess());
    }


}
