package com.tripin.application.domain;

import com.tripin.application.enums.ErrorCode;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Title: Result
 * @Description: 自定义的Http请求返回的结果
 * @Author: Felix
 * @Date: 5/31/2018 14:22
 * @Version: 1.0
 **/

public class Result<T>  implements Serializable {

    private static final long serialVersionUID = 1L;

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
        this.errorCode = errorCode.getCode();
        this.msg = errorCode.getMsg();
        this.data = data;
    }

    public Result(ErrorCode errorCode) {
        this.errorCode = errorCode.getCode();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result<?> result = (Result<?>) o;
        return Objects.equals(getErrorCode(), result.getErrorCode()) &&
                Objects.equals(getMsg(), result.getMsg()) &&
                Objects.equals(getData(), result.getData());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getErrorCode(), getMsg(), getData());
    }

    @Override
    public String toString() {
        return "Result{" +
                "errorCode=" + errorCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
