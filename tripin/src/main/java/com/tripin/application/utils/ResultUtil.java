package com.tripin.application.utils;

import com.tripin.application.domain.Result;
import com.tripin.application.enums.ErrorCode;

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
