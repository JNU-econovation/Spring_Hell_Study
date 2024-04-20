package org.example.springstudy.exception;

import jakarta.persistence.EntityNotFoundException;

public class CategoryNotFoundException extends EntityNotFoundException {
    public CategoryNotFoundException(){
        super("카테고리가 존재하지 않습니다.");
    }
}