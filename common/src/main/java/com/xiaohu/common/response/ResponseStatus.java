package com.xiaohu.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description = "返回状态")
public class ResponseStatus{

    @ApiModelProperty(value = "是否成功")
    private boolean success;
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "返回信息")
    private String message;

//    volatile private static ResponseStatus invalidParam;

    public ResponseStatus(ResultCode code) {
        this.success = code.success();
        this.code = code.code();
        this.message = code.message();
    }

    public ResponseStatus(Integer code,String message,boolean success) {
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public static ResponseStatus responseSuccess(){
        return CommonStatus.SUCCESS;
    }

    public static ResponseStatus responseFail(){
        return CommonStatus.FAIL;
    }

    /**
     * @Author ChenHu
     * @Date 2021/1/9 - 11:38
     * @Description 静态内部类，定义两个通用的成功、失败返回状态
     * 静态内部类，也是懒加载，到用的时候，才实例化（静态变量也是单实例的）
     * @Return
     **/
    private static class CommonStatus{
        private static final ResponseStatus SUCCESS = new ResponseStatus(ResultCode.SUCCESS);
        private static final ResponseStatus FAIL = new ResponseStatus(ResultCode.FAIL);
    }

    /**
     * @Author ChenHu
     * @Date 2021/1/9 - 11:37
     * @Description 定制非法参数异常，单例懒加载
     * 这里不能用单例，因为，单实例的话，不同请求，响应的定制消息不一样。
     * 每个请求，都能讲返回消息的值改了，有覆盖的可能，这样提示的错误消息不精确
     * @Return
     **/
    /*public static ResponseStatus responseInvalidParam(String msg){
        if(invalidParam == null){
            synchronized (ResponseStatus.class){
                if(invalidParam == null){
                    invalidParam = new ResponseStatus(ResultCode.INVALID_PARAM);
                }
            }
        }
        invalidParam.setMessage(msg);

        return ResponseStatus.invalidParam;
    }*/
    public static ResponseStatus responseInvalidParam(String msg){
        return new ResponseStatus(ResultCode.INVALID_PARAM.code,msg,ResultCode.INVALID_PARAM.success);
    }

}
