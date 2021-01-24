package com.xiaohu.model.stock;

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
 * @Date 2021/1/20 - 19:21
 * @Describe
 **/
@Data
@Accessors(chain = true)
@ApiModel("订单表")
@TableName("goods")
public class Stock {

    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("商品id")
    private String goodsId;

    @ApiModelProperty("库存")
    private BigDecimal stock;

    @TableField(exist = false)
    @ApiModelProperty("扣减数")
    private BigDecimal decre;
}
