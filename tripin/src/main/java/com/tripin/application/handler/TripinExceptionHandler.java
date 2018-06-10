package com.tripin.application.handler;

import com.tripin.application.enums.ErrorCode;
import com.tripin.application.exception.TripinException;
import com.tripin.application.domain.Result;
import com.tripin.application.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title: ExceptionHandler
 * @Description: 处理自定义异常TripinException
 * @Author: Felix
 * @Date: 5/31/2018 14:18
 * @Version: 1.0
 **/

@ControllerAdvice
public class TripinExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(TripinExceptionHandler.class);

    @ExceptionHandler(TripinException.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof TripinException) {
            TripinException tripinlException = (TripinException) e;
            return ResultUtil.error(tripinlException.getErrorCode());
        }else {
            logger.error("[SYSTEM ERROR]{}", e);
            return ResultUtil.error(ErrorCode.UNKNOWN_ERROR);
        }
    }

}
