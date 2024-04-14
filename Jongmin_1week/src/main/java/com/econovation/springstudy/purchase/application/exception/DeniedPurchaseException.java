package com.econovation.springstudy.purchase.application.exception;

import com.econovation.springstudy.common.application.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class DeniedPurchaseException extends BusinessException {

    private static String code = "2000";

    private final String message;


    public DeniedPurchaseException(String message){
        super(HttpStatus.FORBIDDEN, message);
        this.message = message;
    }

    @Override
    public String getMessage(){return message;}
}
