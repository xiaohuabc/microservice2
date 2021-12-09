package com.xiaohu.mq.service;

import org.springframework.stereotype.Service;

/**
 * @Author ChenHu
 * @Date 2021/1/29 - 0:42
 * @Describe
 **/
@Service
public class ServiceAImpl implements ServiceA {
    @Override
    public void aa() {
        System.out.println("aaa");
    }
}
