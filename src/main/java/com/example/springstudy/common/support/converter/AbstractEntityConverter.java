package com.example.springstudy.common.support.converter;


import com.example.springstudy.common.persistence.BaseEntity;
import com.example.springstudy.common.support.AbstractModel;

public interface AbstractEntityConverter<T extends BaseEntity, R extends AbstractModel> {

    R from(T t);

    T toEntity(R t);
}