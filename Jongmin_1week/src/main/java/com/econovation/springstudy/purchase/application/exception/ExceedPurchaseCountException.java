package com.econovation.springstudy.purchase.application.exception;

import org.springframework.http.HttpStatus;

public class ExceedPurchaseCountException extends DeniedPurchaseException{

    private static String code = "2000";


    public ExceedPurchaseCountException(){
        super(HttpStatus.FORBIDDEN, code);
    }

    @Override
    public String getMessage(){return "1인당 최대 구매 수량은 8개입니다.";}
}
