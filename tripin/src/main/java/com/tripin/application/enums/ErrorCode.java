package com.tripin.application.enums;

/**
 * @Title: ErrorCode
 * @Description: 自定义异常
 * @Author: Felix
 * @Date: 5/31/2018 14:06
 * @Version: 1.0
 **/

public enum ErrorCode {

    UNKNONW_ERROR(-1, "Unknown Error"),
    SUCCESS(0, "Success");

    private Integer errorCode;

    private String msg;

    ErrorCode(Integer code, String msg) {
        this.errorCode = code;
        this.msg = msg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getMsg() {
        return msg;
    }
}
