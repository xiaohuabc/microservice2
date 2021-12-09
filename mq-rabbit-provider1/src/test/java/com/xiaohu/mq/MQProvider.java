package com.xiaohu.mq;

import com.xiaohu.mq.config.RabbitmqConfig;
import com.xiaohu.mq.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author ChenHu
 * @Date 2021/1/29 - 0:13
 * @Describe
 **/
@SpringBootTest
public class MQProvider {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void topic(){
        System.out.println(rabbitTemplate);

        //中国人
        rabbitTemplate.convertAndSend
                (RabbitmqConfig.Exchange_Name,"boy.china.sing",getMsg("男","中国","唱歌"));
        rabbitTemplate.convertAndSend
                (RabbitmqConfig.Exchange_Name,"girl.china.dancing",getMsg("女","中国","跳舞"));
        //唱歌的人
        rabbitTemplate.convertAndSend
                (RabbitmqConfig.Exchange_Name,"girl.us.sing",getMsg("女","美国","唱歌"));
        //男人
        rabbitTemplate.convertAndSend
                (RabbitmqConfig.Exchange_Name,"boy.ua.dancing",getMsg("男","英国","跳舞"));

        //放user
        rabbitTemplate.convertAndSend
                (RabbitmqConfig.Exchange_Name,"obj.user.xiaohu",new User().setId(123).setName("陈虎"));
    }



    public String getMsg(String 性别,String 国籍,String 爱好){
        String msg = "性别:{a},国籍:{b},爱好:{c}";
        return msg.replace("{a}",性别)
                .replace("{b}",国籍)
                .replace("{c}",爱好);
    }

}
