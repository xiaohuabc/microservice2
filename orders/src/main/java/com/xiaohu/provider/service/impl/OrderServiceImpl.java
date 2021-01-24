package com.xiaohu.provider.service.impl;

import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.common.response.ResponseStatus;
import com.xiaohu.model.account.Account;
import com.xiaohu.model.order.Order;
import com.xiaohu.model.order.OrderRequest;
import com.xiaohu.model.stock.Stock;
import com.xiaohu.provider.mapper.OrderMapper;
import com.xiaohu.provider.service.OrderService;
import com.xiaohu.provider.service.AccountService;
import com.xiaohu.provider.service.StockService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Author ChenHu
 * @Date 2021/1/20 - 23:41
 * @Describe
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;

    @Resource
    StockService stockService;

    @Resource
    AccountService accountService;

    @GlobalTransactional
    @Override
    public ResponseObjectResult createOrder(OrderRequest orderRequest) {

        //写入订单
        orderMapper.insert(new Order().setOrderId(UUID.randomUUID().toString().replace("-","")));

        //扣减库存
        stockService.decreStock(new Stock().setDecre(orderRequest.getDecre()));

        //扣减金额
        accountService.discount(new Account().setDiscount(new BigDecimal("20")).setUserId("1001"));

        return new ResponseObjectResult(ResponseStatus.responseSuccess());
    }
}
