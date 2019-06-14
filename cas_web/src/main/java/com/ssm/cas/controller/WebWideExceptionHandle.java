package com.ssm.cas.controller;

import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author: 胖虎
 * @date: 2019/6/13 22:57
 **/
@ControllerAdvice
public class WebWideExceptionHandle {

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public String httpMessageNotWritableExceptionHandle(){
        return "500";
    }

}
