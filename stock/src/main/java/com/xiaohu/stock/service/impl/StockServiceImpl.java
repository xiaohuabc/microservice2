package com.xiaohu.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xiaohu.common.exception.MyException;
import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.common.response.ResponseStatus;
import com.xiaohu.model.stock.Stock;
import com.xiaohu.stock.mapper.StockMapper;
import com.xiaohu.stock.service.StockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Author ChenHu
 * @Date 2021/1/24 - 21:40
 * @Describe
 **/
@Service
public class StockServiceImpl implements StockService {

    @Resource
    StockMapper stockMapper;

    @Override
    public ResponseObjectResult decreStock(Stock stock) {

        if(stock.getDecre().compareTo(new BigDecimal("2")) != 0){
            throw new MyException("扣减库存不是2，就失败！");
        }
        Stock oldStock = stockMapper.selectOne(new LambdaQueryWrapper<Stock>().eq(Stock::getGoodsId, "2002"));
        stock.setStock(oldStock.getStock().subtract(stock.getDecre()));

        stockMapper.decreStock(stock);
        return new ResponseObjectResult(ResponseStatus.responseSuccess());
    }
}
