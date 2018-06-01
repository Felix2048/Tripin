package com.tripin.application.exception;

import com.tripin.application.enums.ErrorCode;

/**
 * @Title: TripinException
 * @Description: 自定义异常TripinException
 * @Extends: RuntimeException
 * @Author: Felix
 * @Date: 5/31/2018 14:15
 * @Version: 1.0
 **/

public class TripinException extends RuntimeException {

    private ErrorCode errorCode;

    public TripinException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "TripinException{" +
                "errorCode=" + errorCode +
                '}';
    }
}
