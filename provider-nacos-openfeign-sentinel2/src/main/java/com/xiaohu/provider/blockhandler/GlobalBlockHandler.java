package com.xiaohu.provider.blockhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author ChenHu
 * @Date 2021/1/14 - 13:12
 * @Describe
 **/
@Slf4j
public class GlobalBlockHandler {

    public static String block1(BlockException blockException){
        log.error("block1兜底方法执行！", blockException);
        return "block1";
    }

    public static String block2(BlockException blockException){
        log.error("block2兜底方法执行！" + blockException);
        return "block2";
    }
}
