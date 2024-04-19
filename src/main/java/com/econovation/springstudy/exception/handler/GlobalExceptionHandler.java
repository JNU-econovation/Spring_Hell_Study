package com.econovation.springstudy.exception.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleAllException(Exception e){
        System.out.println(e.getMessage());
        return "오류가 발생했습니다...";
    }
}
