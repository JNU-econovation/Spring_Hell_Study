package com.econovation.springstudy.common.application.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{

    private HttpStatus status;
    private String code;

    public BusinessException(HttpStatus status, String code){
        this.status = status;
        this.code = code;
    }

    public HttpStatus getStatus(){ return status;}

}
