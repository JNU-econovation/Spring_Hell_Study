package org.example.springstudy.exception;

public class CityHallUserOrderCountException extends RuntimeException {
    public CityHallUserOrderCountException(){
        super("주문은 100개 단위로 가능합니다.");
    }
}