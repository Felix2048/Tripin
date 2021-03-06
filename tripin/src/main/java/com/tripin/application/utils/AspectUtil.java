package com.tripin.application.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AspectUtil {

    private static final Logger logger = LoggerFactory.getLogger("com.gwon.aspect.HttpAspect");

    @Pointcut("execution(public * com.tripin.application.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        request.getRequestURL();
        request.getMethod();
        request.getRemoteAddr();
        joinPoint.getSignature().getDeclaringTypeName();
        joinPoint.getSignature().getName();
        joinPoint.getArgs();
    }

    @After("log()")
    public void doAfter() {

    }

//    @AfterReturning(returning = "basejson",pointcut = "log()")
//    public void doAfterReturning(BaseJson basejson) {
//
//    }
}
