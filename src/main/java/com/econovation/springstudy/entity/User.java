package com.econovation.springstudy.entity;

import com.econovation.springstudy.config.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;

    private String password;

    private UserRole userRole;

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public User(String userId, String password, UserRole userRole) {
        this.userId = userId;
        this.password = password;
        this.userRole = userRole;
    }

    protected User() {}

}
