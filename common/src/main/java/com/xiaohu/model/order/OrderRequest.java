package com.xiaohu.model.order;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Author ChenHu
 * @Date 2021/1/24 - 21:22
 * @Describe
 **/
@Data
@Accessors(chain = true)
@ApiModel("订单请求数据，模型封装")
public class OrderRequest {

    String goodsId;

    BigDecimal saleCount;

    BigDecimal decre;


}
