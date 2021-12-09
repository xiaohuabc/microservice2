package com.xiaohu.mq;

import com.xiaohu.mq.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @Author ChenHu
 * @Date 2021/1/29 - 1:06
 * @Describe
 **/
@Slf4j
@SpringBootTest
public class MQConsumer {

    @Test
    void test() throws InterruptedException {

        while (true){
            TimeUnit.SECONDS.sleep(1);
        }
    }

    /**
     * 中国
     * @param msg
     */
    @RabbitListener(queues = "topic1")
    public void topic1(String msg){
        log.info("topic1监听到的消息--中国--->"+msg);
    }

    /**
     * 男
     * @param msg
     */
    @RabbitListener(queues = "topic2")
    public void topic2(String msg){
        log.info("topic2监听到的消息--男--->"+msg);
    }

    /**
     * 唱歌
     * @param msg
     */
    @RabbitListener(queues = "topic3")
    public void topic3(String msg){

        log.info("topic3监听到的消息--唱歌--->"+msg);
    }
    @RabbitListener(queues = "topic4")
    public void topic4(User user){
        log.info("topic收到了一个对象：--->"+ user);
        log.info("topic收到了一个对象：--->"+ user.toString());
    }

}
