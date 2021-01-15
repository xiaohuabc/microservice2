package com.xiaohu.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel(description = "实体返回类")
public class ResponseObjectResult{

    @ApiModelProperty(value = "封装对象数据")
    private Object data;
    @ApiModelProperty(value = "封装响应状态")
    private ResponseStatus status;

    public ResponseObjectResult(ResponseStatus status) {
        this.status = status;
    }

    public ResponseObjectResult(ResponseStatus status, Object data) {
        this.data = data;
        this.status = status;
    }

    /**
     * @Author ChenHu
     * @Date 2020/8/7-18:12
     * @Description 单例模式，响应操作成功
     * @Return
     **/
    public static ResponseObjectResult responseSuccess(){
        return CommonResponse.SUCCESS;
    }
    public static ResponseObjectResult responseFail(){
        return CommonResponse.FAIL;
    }

    public static ResponseObjectResult responseInvalidParam(String msg){
        return new ResponseObjectResult(ResponseStatus.responseInvalidParam(msg));
    }

    private static class CommonResponse{
        private static final ResponseObjectResult SUCCESS = new ResponseObjectResult(ResponseStatus.responseSuccess());
        private static final ResponseObjectResult FAIL = new ResponseObjectResult(ResponseStatus.responseFail());
    }

}
