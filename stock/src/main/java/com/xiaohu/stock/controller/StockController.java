package com.xiaohu.stock.controller;

import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.model.stock.Stock;
import com.xiaohu.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ChenHu
 * @Date 2021/1/24 - 20:42
 * @Describe
 **/
@RequestMapping("/stock")
@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @PostMapping("/decreStock")
    ResponseObjectResult decreStock(@RequestBody Stock stock){
        return stockService.decreStock(stock);
    }

}
