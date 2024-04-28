package com.econovation.hellstudy.user.repository;


import com.econovation.hellstudy.user.domain.User;

import java.util.Optional;

public interface UserRepository {
    public void save(User user);
    public User findById(String userId);
}
