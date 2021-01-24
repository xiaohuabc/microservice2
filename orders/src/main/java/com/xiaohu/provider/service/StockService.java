package com.xiaohu.provider.service;

import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.model.stock.Stock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author ChenHu
 * @Date 2021/1/24 - 22:03
 * @Describe
 **/
@Component
@FeignClient("stock")
public interface StockService {

    @PostMapping("/stock/decreStock")
    ResponseObjectResult decreStock(@RequestBody Stock stock);
}
