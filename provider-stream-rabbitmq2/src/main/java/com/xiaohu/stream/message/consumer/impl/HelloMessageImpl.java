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

    //@Resource 默认会按照属性名字匹配。匹配不到就，会找类型或其子类的实现，多个会报错。name属性能指定名字
    //@AutoWired 默认按照类型匹配，匹配不上或者匹配多个会报错。@Qualifier能按名称注入时，指定注入的名字
    @Resource
    MessageChannel output;

    @Override
    public String sayHallo() {

        output.send(MessageBuilder.withPayload("Hello World").build());
        return "发送成功";
    }
}
