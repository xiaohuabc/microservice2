package com.xiaohu.common.exception;

import com.xiaohu.common.response.ResponseObjectResult;
import com.xiaohu.common.response.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @Author ChenHu
 * @Date 2021/1/9 - 15:24
 * @Describe 全局错误消息处理。需要web模块支持
 * @RestControllerAdvice 等价于 @ControllerAdvice + @ResponseBody
 *
 * 对存放目录有要求。需要让，Spring扫描到，才能生效。
 * SpringBoot默认扫描主启动类所在包及其子包下
 * 看有没有办法，把他抽取出来，作为公共模块，只要引入了，对所有模块都生效
 *
 * 解决方案：在主启动类上面，添加扫描全局异常处理类，所在的包
 * @SpringBootApplication(scanBasePackages = {"com.xiaohu.provider","com.xiaohu.common.exception"})
 **/
@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MyException.class)
    ResponseObjectResult handleMyException(MyException e){
        log.error("[MyException]=======>>>:执行异常：{}",e.getMsg(),e);

        //自定义异常消息，可以返回给客户
        return ResponseObjectResult.responseInvalidParam(e.getMsg());
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseObjectResult handleRuntimeException(RuntimeException e){
        log.error("[RuntimeException]=======>>>:执行异常：{}",e.getMessage(),e);

        return ResponseObjectResult.responseFail();
    }

    @ExceptionHandler(Exception.class)
    ResponseObjectResult handleException(Exception e){
        //e.getMessage() 不要返回给客户，非定制化的错误消息，可能很长，不可预期（自己查日志即可）
        log.error("[Exception]=======>>>:执行异常：{}",e.getMessage(),e);

        return ResponseObjectResult.responseFail();
    }

    /**
     * @Author ChenHu
     * @Date 2021/1/9 - 19:52
     * @Description 自定义返回错误消息
     * @Return
     **/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseObjectResult validationBodyException(MethodArgumentNotValidException exception){

        BindingResult result = exception.getBindingResult();

        if(result == null || !result.hasErrors()){
            return ResponseObjectResult.responseFail();
        }

        List<ObjectError> errors = result.getAllErrors();
        log.error("[MethodArgumentNotValidException]=======>>>:表单参数校验异常：{}",errors);

        //定制返回错误消息
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (ObjectError e : errors) {
            FieldError error = (FieldError) e;

            sb.append(error.getField());
            sb.append(":");
            sb.append(error.getDefaultMessage());

            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");

        return new ResponseObjectResult(ResponseStatus.responseInvalidParam(sb.toString()));
    }


}
