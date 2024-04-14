package com.econovation.springstudy.common.application.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public BusinessException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus(){ return status;}
    public String getMessage(){ return message; }

}
