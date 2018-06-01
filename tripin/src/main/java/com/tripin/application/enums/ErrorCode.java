package com.tripin.application.enums;

/**
 * @Title: ErrorCode
 * @Description: 自定义异常
 * @Author: Felix
 * @Date: 5/31/2018 14:06
 * @Version: 1.0
 **/

public enum ErrorCode {

    UNKNONW_ERROR(-1, "Unknown Error"), //  未知错误
    SUCCESS(0, "Success"),
    INSERTION_ERROR(100, "Fail to Insert"),
    UPDATE_ERROR(101, "Fail to Update"),
    DELETION_ERROR(102, "Fail to Delete"),
    LOGIN_ERROR(400, "Fail to Login"),
    UNAUTHORIZED(401, "Access Deny");

    private Integer code;

    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
