package com.econovation.springstudy.purchase.application.exception;

import org.springframework.http.HttpStatus;

public class InsufficientRemainException extends DeniedPurchaseException{

    private static String code ="2001";

    public InsufficientRemainException(){
        super(HttpStatus.FORBIDDEN, code);
    }

    @Override
    public String getMessage() {return "재고가 부족하여 구매할 수 없습니다.";}
}
