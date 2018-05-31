package com.tripin.application.utils;

import com.tripin.application.domain.Result;
import com.tripin.application.enums.ErrorCode;

/**
 * @Title: ResultUtil
 * @Description: 用于自定义的Http请求返回的结果Result的util
 * @Author: Felix
 * @Date: 5/31/2018 14:26
 * @Version: 1.0
 **/

public class ResultUtil {

    public static Result success(Object object) {
        return new Result(ErrorCode.SUCCESS, object);
    }

    public static Result success() {
        return new Result(ErrorCode.SUCCESS, null);
    }

    public static Result error(ErrorCode errorCode) {
        return new Result(errorCode);
    }

}
