package com.xiaohu.provider.service;

import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.model.account.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author ChenHu
 * @Date 2021/1/20 - 23:34
 * @Describe
 **/
@Component
@FeignClient("account")
public interface AccountService {

    @PostMapping("/account/discount")
    ResponseObjectResult discount(@RequestBody Account account);
}
