package com.xiaohu.mq.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author ChenHu
 * @Date 2021/1/29 - 0:41
 * @Describe
 **/
@SpringBootTest
public class TestA {

    @Autowired
    ServiceA serviceA;

    @Autowired
    ServiceB serviceB;

    @Test
    void test(){
        serviceA.aa();
    }

}
