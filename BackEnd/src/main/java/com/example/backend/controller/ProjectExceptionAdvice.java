package com.example.backend.controller;

import com.example.backend.exception.BusinessException;
import com.example.backend.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex) {
        System.out.println("系统出现异常");
        return new Result(ex.getCode(),ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public Result doSystemException(BusinessException ex) {
        System.out.println("出现业务异常");
        return new Result(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e) {
        System.out.println("出现其他异常");
        System.out.println(e);
        return new Result(Code.SYSTEM_UNKNOWN_ERROR, "系统繁忙，请稍后再试");
    }
}
