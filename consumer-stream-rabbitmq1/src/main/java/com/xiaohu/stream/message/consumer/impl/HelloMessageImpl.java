package com.xiaohu.stream.message.consumer.impl;

import com.xiaohu.stream.message.consumer.HelloMessage;
import org.springframework.stereotype.Component;

/**
 * @Author ChenHu
 * @Date 2021/1/17 - 16:42
 * @Describe
 **/
@Component
//@EnableBinding(Sink.class)
public class HelloMessageImpl implements HelloMessage {

//    @Resource
//    MessageChannel output;

    @Override
    public String sayHallo() {

//        output.send(MessageBuilder.withPayload("Hello World").build());

        /*String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return null;*/
        return "发送成功";
    }
}
