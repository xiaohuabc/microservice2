package com.xiaohu.provider;

import com.alibaba.fastjson.JSON;
import com.xiaohu.model.UserInfo;
import org.junit.jupiter.api.Test;

/**
 * @Author ChenHu
 * @Date 2021/1/9 - 20:19
 * @Describe
 **/
public class TestJson {

    @Test
    void testJson1(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1).setMuser("232");
        System.out.println(JSON.toJSONString(userInfo));
    }

    @Test
    void testN(){
        StringBuffer sb = new StringBuffer();
        sb.append("aaa\n");
        sb.append("bbb\n");
        sb.append("ccc\n");

        System.out.println(sb.toString());
    }
}
