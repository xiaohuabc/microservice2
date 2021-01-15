package com.xiaohu.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ChenHu
 * @Date 2021/1/9 - 15:25
 * @Describe 自定义错误消息类（规范点的话，需要严格定义错误编码。我这里只定义具体错误消息）
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyException extends RuntimeException {
    private String msg;
}
