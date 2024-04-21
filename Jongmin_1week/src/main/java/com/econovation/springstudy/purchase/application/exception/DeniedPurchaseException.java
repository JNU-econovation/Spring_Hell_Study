package com.econovation.springstudy.purchase.application.exception;

import com.econovation.springstudy.common.application.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class DeniedPurchaseException extends BusinessException {

    public DeniedPurchaseException(HttpStatus status, String code){
        super(status, code);
    }
}
