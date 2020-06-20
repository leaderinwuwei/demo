package com.captain.demo.common.enums;

/**
 * Created by pigun on 2019/8/26.
 */
public enum EnumResultCode {
    SUCCESS(200,"请求成功"),
    FAIL(400,"请求无效"),
    UNAUTHORIZED(401,"请求未授权"),
    TOKEN_IS_EXPIRED(4001,"token is expired"),
    INVALID_TOKEN(4002,"invalid token"),
    INVALID_CODE(4003,"验证码错误"),
    NOT_FOUND(404,"请求失败"),
    INTERNAL_SERVER_ERROR(500,"服务异常"),


    //用户异常---------------------------S
    NOT_EXIST_RECORD_DB(101,"无此记录"),
    INVALID_PARAMS(102,"传入参数不合法"),
    USER_NO_LOGIN(103,"用户未登录"),
    NOT_EXIST_ORDER_RECORD_DB(104,"无此订单"),
    NOT_ALLOW_CANNEL_ORDER(105,"订单不可取消"),
    //用户异常---------------------------E



    /*二维码异常*/
    INVALID_CODE_NULL(5001,"二维码不合法")
    ;
    private final int code;
    private final String msg;

    EnumResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
