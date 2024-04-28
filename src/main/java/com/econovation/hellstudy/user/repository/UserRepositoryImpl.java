package com.econovation.hellstudy.user.repository;

import com.econovation.hellstudy.chat.domain.ChatRoom;
import com.econovation.hellstudy.user.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    // key: userId, value : User
    private Map<String, User> userRepository =  new HashMap<>();
    // key: userId, value: chatRooms
    private Map<String, List<ChatRoom>> chatRooms = new HashMap<>();
    @Override
    public void save(User user) {
        userRepository.put(user.getId(), user);
    }

    @Override
    public User findById(String userId) {
        return userRepository.get(userId);
    }
}
