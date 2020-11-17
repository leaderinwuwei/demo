/**
 * pxys
 * Copyright (C) 2017-2019 All Rights Reserved.
 */
package com.captain.demo.common.utils;/**
 * Created by pigun on 2019/8/26.
 */

import com.alibaba.fastjson.JSON;
import com.captain.demo.common.enums.EnumResultCode;
import org.apache.http.entity.ContentType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: ResponseUtil
 * @Description:
 * @Author: Monta
 * @Date: 2019/8/26 下午2:53
 **/
public class ResponseUtil {

    /**
     * 根据消息码等生成接口返回对象
     *
     * @param enumResultCode 结果返回码
     * @param data           数据对象
     * @param <T>
     * @return
     */
    public static <T> Result<T> builderResponse(EnumResultCode enumResultCode, T data) {
        Result<T> res = new Result<>();
        res.setCode(enumResultCode.getCode());
        res.setMsg(enumResultCode.getMsg());
        res.setData(data);
        return res;
    }

    public static <T> Result<T> builderResponse(EnumResultCode enumResultCode) {
        Result<T> res = new Result<>();
        res.setCode(enumResultCode.getCode());
        res.setMsg(enumResultCode.getMsg());
        return res;
    }

    /**
     * 根据消息码等生成接口返回对象
     *
     * @param code 结果返回码
     * @param msg  结果返回消息
     * @param data 数据对象
     * @param <T>
     * @return
     */
    public static <T> Result<T> builderResponse(int code, String msg, T data) {
        Result<T> res = new Result<>();
        res.setCode(code);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }


    public static <T> Result<T> builderErrResponse(EnumResultCode enumResultCode) {
        Result<T> res = new Result<>();
        res.setCode(enumResultCode.getCode());
        res.setMsg(enumResultCode.getMsg());
        return res;
    }

    /**
     * 根据消息码等生成接口返回对象
     *
     * @param code 结果返回码
     * @param msg  结果返回消息
     * @param <T>
     * @return
     */
    public static <T> Result<T> builderErrResponse(int code, String msg) {
        Result<T> res = new Result<>();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }

    /**
     * 请求异常返回结果
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> exception() {
        return builderResponse(EnumResultCode.INTERNAL_SERVER_ERROR.getCode(), "服务异常", null);
    }

    /**
     * @param <T>
     * @return
     */
    public static <T> Result<T> exception(Integer code, String message) {
        return builderResponse(code, message, null);
    }

    /**
     * 封装
     * 请求接口时，传入参数有误的异常处理
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> paramException() {
        return builderResponse(EnumResultCode.INVALID_PARAMS.getCode(), EnumResultCode.INVALID_PARAMS.getMsg(), null);
    }


    public static void returnJson(HttpServletResponse response, EnumResultCode enumResultCode) {
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType(ContentType.APPLICATION_JSON.getMimeType());
            writer = response.getWriter();
            Result res = new Result();
            res.setCode(enumResultCode.getCode());
            res.setMsg(enumResultCode.getMsg());
            writer.write(JSON.toJSONString(res));
            writer.close();
        } catch (IOException e) {

        }
    }

}