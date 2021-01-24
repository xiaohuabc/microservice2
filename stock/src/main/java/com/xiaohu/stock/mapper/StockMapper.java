package com.xiaohu.stock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohu.model.stock.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author ChenHu
 * @Date 2021/1/24 - 21:42
 * @Describe
 **/
@Mapper
public interface StockMapper extends BaseMapper<Stock> {

    int decreStock(@Param("stock") Stock stock);
}
