package com.xiaohu.common.response;

/**
 * 公共的返回码
 *    返回码code：
 *      成功：10000
 *      失败：10001
 *      未登录：10002
 *      未授权：10003
 *      抛出异常：99999
 */
public enum ResultCode {

    /*公用返回状态*/
    SUCCESS(true,10000,"操作成功！"),
    FAIL(false,20000,"操作失败!"),
    INVALID_PARAM(false,30000,"非法参数！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！"),


    /*认证部分*/
    UNAUTHENTICATED(false,10002,"您还未登录!"),
    UNAUTHORISE(false,10003,"权限不足!"),
    USERNAME_OR_PASSWORDERROR(false,10004,"用户名或密码错误!"),
    USERNAME_IS_ERROR(false,10005,"用户名不存在!"),
    PASSWORD_IS_ERROR(false,10006,"密码错误!"),
    USERNAME_OR_PASSWORD_IS_NULL(false,10007,"用户名或密码为空!"),
    LOCKED_ACCOUNT(false,10008,"账户被锁定，请联系管理员!"),
    ERRORCOUNT_IS_MAX(false,10009,"错误次数已达上限，请稍后重试!"),
    LOGIN_TIMEOUT(false,10010,"登录超时，请重新登录!"),
    HMAC_ERROR(false,10011,"HMAC认证失败，请重试!"),
    TOKEN_IS_ILLEAGE(false,10012,"账号已在其他设备登录，请重新登录!"),
    LOGINOUT_SUCCESS(false,10013,"退出登录成功!"),
    USERINFO_NOT_ENOUGH(false,10014,"用户信息不完整!"),
    VERTIFYCODE_NEED(false,10015,"需要验证码!"),
    USERINFO_EXIST(false,10016,"用户编号信息重复!"),
    TOKEN_TIMEOUT(false,10017,"Token已过期!"),
    TOKEN_NONE(false,10019,"请传入正确的token信息"),
    USER_NOT_EXIST(false,10020,"用户不存在!"),
    USER_CERT_NOT_EXIST(false,10021,"员工证书不存在!"),
    USER_PHONE_EXIST(false,10022,"用户电话号码重复!"),
    USER_CARDNO_EXIST(false,10023,"用户卡号重复!"),
    USER_CARDNO_USED(false,10024,"用户卡号已被使用，请先解除绑定!"),
    USER_CARDTYPE_ERROR(false,10025,"用户卡类型错误!"),
    USER_CARDTYPE_PLATFORM_ERROR(false,10026,"用户平台与卡类型不符!"),

    INTERFACE_CALL_FAILED(false,30000,"接口调用失败"),
    USER_INFORMATION_ACQUISITION_FAILED(false,30002,"从redis获取用户信息失败！"),
    FILE_UPLOAD_FAILED(false,30003,"文件上传失败！"),
    FILE_CANNOTCONTAINCOMMA(false,30004,"文件名中不能含有英文逗号！"),
    FILE_EXECUTABLEFILE_NOTALLOW(false,30005,"禁止上传可执行类文件！"),
    FILE_TYPE_NOT_SUPPORT (false,30006,"文件类型不支持！"),
    FILE_IS_TOO_LARGE (false,30007,"文件过大，不能超过200K！"),
    FILE_FORMAT_NOTALLOW(false,30008,"上传文件格式不允许！"),
    S_DICTIONARY_ERROR(false,39009,"数据字典表数据错误！"),
    FILE_INVALID_DATE(false,30010,"导入文件没有有效数据！"),
    FILE_ERROR_DATE(false,30011,"导入文件存在错误数据！")


    ;

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    ResultCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}
