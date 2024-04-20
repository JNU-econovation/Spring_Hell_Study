package org.example.springstudy.exception;

public class OrderPriceException extends RuntimeException {
    public OrderPriceException(){
        super("주문 가격은 0원 이하일 수 없습니다.");
    }
}
