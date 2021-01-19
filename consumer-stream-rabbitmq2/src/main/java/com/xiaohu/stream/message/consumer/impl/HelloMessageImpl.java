package com.xiaohu.stream.message.consumer.impl;

import com.xiaohu.stream.message.consumer.HelloMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @Author ChenHu
 * @Date 2021/1/17 - 16:42
 * @Describe
 **/
@Component
@EnableBinding(Sink.class)
public class HelloMessageImpl implements HelloMessage {

    @Value("${server.port}")
    private String prot;

    @StreamListener(Sink.INPUT)
    @Override
    public void getHello(Message<String> message) {

        System.out.println("消费者2号，接收：" + message.getPayload() + "\t port:" + prot);
    }
}
