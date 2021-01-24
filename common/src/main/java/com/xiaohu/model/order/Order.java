package com.xiaohu.model.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author ChenHu
 * @Date 2021/1/20 - 19:20
 * @Describe 订单表
 **/
@Data
@Accessors(chain = true)
@ApiModel("订单表")
@TableName("orders")
public class Order {

    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("订单号")
    private String orderId;
}
