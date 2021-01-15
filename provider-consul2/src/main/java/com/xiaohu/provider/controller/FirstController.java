package com.xiaohu.provider.controller;

import com.xiaohu.common.exception.MyException;
import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.common.response.ResponseStatus;
import com.xiaohu.model.UserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenHu
 * @Date 2021/1/9 - 13:25
 * @Describe
 **/
@RestController
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/get")
    public ResponseObjectResult get(){
        UserInfo model = new UserInfo();
//        model.userName("test").age(13);
//        int a = 5/0;
        System.out.println("aaa");

        if(true){
            throw new MyException("测试执行异常");
        }
        return new ResponseObjectResult(ResponseStatus.responseSuccess(),model);
    }

}
