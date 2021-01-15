package com.xiaohu.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


/**
 * @Author ChenHu
 * @Date 2020/5/26-15:04
 * @Describe
 **/
@TableName("user_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
//@Accessors的fluent = true属性还是别用了吧，在Mybatis-plus封装返回结果集的时候有问题，找不到属性，导致装配失败
//fluent属性的作用是，干掉get、set
//@Accessors(chain = true,fluent = true)
@Accessors(chain = true)
@ApiModel("用户表")
public class UserInfo extends BaseModel {

    @ApiModelProperty("用户id")
    private String userId;

    @NotNull(message = "用户名不能为空！")
    @ApiModelProperty("用户名")
    private String userName;

    @DecimalMax(value = "2000")
    @ApiModelProperty("财产")
    private BigDecimal money;

    @Max(value=120,message="年龄最大不能查过120")
    @ApiModelProperty("年龄")
    private Integer age;
}
