package com.example.springstudy.common.support.converter;


import com.example.springstudy.common.support.AbstractModel;
import com.example.springstudy.common.support.dto.AbstractDto;

public interface AbstractDtoConverter<T extends AbstractDto, R extends AbstractModel> {
    R from(T t);
}