package com.xiaohu.provider.controller;

import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.common.response.ResponseStatus;
import com.xiaohu.model.order.OrderRequest;
import com.xiaohu.provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenHu
 * @Date 2021/1/20 - 23:39
 * @Describe
 **/
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseObjectResult createOrder(@RequestBody OrderRequest orderRequest){

        orderService.createOrder(orderRequest);
        return new ResponseObjectResult(ResponseStatus.responseSuccess());
    }

}
