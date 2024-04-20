package org.example.springstudy.exception;

import jakarta.persistence.EntityNotFoundException;

public class GoodsNotFoundException extends EntityNotFoundException {
    public GoodsNotFoundException(){
        super("굿즈가 존재하지 않습니다.");
    }
}