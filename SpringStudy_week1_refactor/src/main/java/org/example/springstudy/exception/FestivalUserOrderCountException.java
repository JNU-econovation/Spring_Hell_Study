package org.example.springstudy.exception;

public class FestivalUserOrderCountException extends RuntimeException {
    public FestivalUserOrderCountException(){
        super("굿즈는 8개까지 구매할 수 있습니다.");
    }
}