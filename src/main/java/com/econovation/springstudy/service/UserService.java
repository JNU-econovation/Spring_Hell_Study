package com.econovation.springstudy.service;

import com.econovation.springstudy.entity.User;
import com.econovation.springstudy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//헬퍼

    public Optional<User> getUser(String userId){
        return userRepository.findByUserId(userId);
    }

    public User getUserOrThrow(Long id){
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("그런 유저 없어요"));
    }
}
