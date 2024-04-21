package com.econovation.springstudy.service;

import com.econovation.springstudy.config.enums.UserRole;
import com.econovation.springstudy.entity.User;
import com.econovation.springstudy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Optional<User> getUser(String userId){
        return userRepository.findByUserId(userId);
    }
    @Transactional(readOnly = true)
    public User getUserOrThrow(Long id){
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("그런 유저 없어요"));
    }
    @Transactional(readOnly = true)
    public User getUserOrThrow(String userId){
        return userRepository.findByUserId(userId).orElseThrow(()->new IllegalArgumentException("그런 유저 없어요"));
    }
    @Transactional
    public User createUser(String userId, String password){
        User user = new User(userId, password, UserRole.NONE);
        return userRepository.save(user);
    }

}
