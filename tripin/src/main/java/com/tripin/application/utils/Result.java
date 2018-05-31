package com.tripin.application.utils;

import com.tripin.application.enums.ErrorCode;

/**
 * @Title: Result
 * @Description: 自定义的Http请求返回的结果
 * @Author: Felix
 * @Date: 5/31/2018 14:22
 * @Version: 1.0
 **/

public class Result<T> {

    /** 错误码. */
    private Integer errorCode;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T data;

    public Result() {
    }

    public Result(Integer errorCode, String msg, T data) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
    }

    public Result(ErrorCode errorCode, T data) {
        this.errorCode = errorCode.getErrorCode();
        this.msg = errorCode.getMsg();
        this.data = data;
    }

    public Result(ErrorCode errorCode) {
        this.errorCode = errorCode.getErrorCode();
        this.msg = errorCode.getMsg();
        this.data = null;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
