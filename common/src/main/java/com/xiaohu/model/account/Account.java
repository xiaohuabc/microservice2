package com.xiaohu.model.account;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Author ChenHu
 * @Date 2021/1/20 - 23:26
 * @Describe
 **/

@ApiModel("用户账户")
@Data
@Accessors(chain = true)
@TableName("account")
public class Account {

    @TableId(value = "id" ,type = IdType.AUTO)
    @ApiModelProperty("id")
    Integer id;

    @ApiModelProperty("用户id")
    String userId;

    @ApiModelProperty("账户余额")
    BigDecimal money;

    @TableField(exist = false)
    @ApiModelProperty("扣减金额")
    BigDecimal discount;


}
