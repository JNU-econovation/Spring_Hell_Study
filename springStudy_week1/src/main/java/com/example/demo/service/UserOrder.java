package com.example.demo.service;

import com.example.demo.domain.GoodsRepository;
import com.example.demo.domain.UserRepository;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public class UserOrder {
    private final UserRepository userRepository;
    private final GoodsRepository goodsRepository;

    public UserOrder(UserRepository userRepository, GoodsRepository goodsRepository) {
        this.userRepository = userRepository;
        this.goodsRepository = goodsRepository;
    }

    public void order(){

    }
}
