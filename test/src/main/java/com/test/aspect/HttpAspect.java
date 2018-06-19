package com.test.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger((HttpAspect.class));

    @Pointcut("execution(public * com.test.controller.Repository.*(..))")
    public void log() {
        logger.info("-------Pointcut");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("--------Before");
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url{}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //class method
        logger.info("class_mothod={}", joinPoint.getSignature().getDeclaringTypeName() + "." +joinPoint.getSignature().getName());
        //parameter
        logger.info("parameter={}", joinPoint.getArgs());
        //IP
        logger.info("IP={}", request.getRemoteAddr());
    }


    @After("log()")
    public void doAfter() {
        logger.info("---------After!!!");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}
