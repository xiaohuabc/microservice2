package com.xiaohu.stream.message.consumer;

import org.springframework.messaging.Message;

/**
 * @Author ChenHu
 * @Date 2021/1/17 - 16:41
 * @Describe
 **/
public interface HelloMessage {

    void getHello(Message<String> message);
}
