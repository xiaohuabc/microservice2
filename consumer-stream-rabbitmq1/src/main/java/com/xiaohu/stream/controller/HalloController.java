package com.xiaohu.stream.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author ChenHu
 * @Date 2021/1/17 - 16:47
 * @Describe
 **/
//@RequestMapping("/hello")
//@RestController
@EnableBinding(Sink.class)
@Component
public class HalloController {

    @Value("${server.port}")
    private String prot;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        System.out.println("消费者1号，接收：" + message.getPayload() + "\t port:" + prot);
    }

}
