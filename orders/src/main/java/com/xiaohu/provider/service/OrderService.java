package com.xiaohu.provider.service;

import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.model.order.OrderRequest;

/**
 * @Author ChenHu
 * @Date 2021/1/20 - 23:41
 * @Describe
 **/
public interface OrderService {
    ResponseObjectResult createOrder(OrderRequest orderRequest);
}
