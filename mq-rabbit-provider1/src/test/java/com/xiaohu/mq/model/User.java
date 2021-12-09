package com.xiaohu.mq.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author ChenHu
 * @Date 2021/1/29 - 1:15
 * @Describe
 **/
@Data
@Accessors(chain = true)
@ToString
public class User implements Serializable {
    private Integer id;
    private String name;
}
