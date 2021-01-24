package com.xiaohu.stock.service;

import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.model.stock.Stock;

/**
 * @Author ChenHu
 * @Date 2021/1/24 - 21:39
 * @Describe
 **/
public interface StockService {

    ResponseObjectResult decreStock(Stock stock);
}
