package com.xiaohu.stream.message.consumer.impl;

import com.xiaohu.stream.message.consumer.HelloMessage;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author ChenHu
 * @Date 2021/1/17 - 16:42
 * @Describe
 **/
@Component
@EnableBinding(Source.class)
public class HelloMessageImpl implements HelloMessage {

    @Resource
    MessageChannel output;

    @Override
    public String sayHallo() {

        output.send(MessageBuilder.withPayload("Hello World").build());

        /*String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return null;*/
        return "发送成功";
    }
}
