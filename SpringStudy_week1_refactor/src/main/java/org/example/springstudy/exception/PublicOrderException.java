package org.example.springstudy.exception;

public class PublicOrderException extends RuntimeException {
    public PublicOrderException() {
        super("공직자의 굿즈 판매량은 전체 굿즈 판매량의 30%를 넘을 수 없습니다.");
    }
}
