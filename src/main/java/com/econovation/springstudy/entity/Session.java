package com.econovation.springstudy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Session {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(unique = true)
    private UUID id;
    @Column(nullable = false)
    private LocalDateTime expiredAt;
    private Long userId;

    public UUID getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Session(Long userId) {
        this();
        this.userId = userId;
    }
    public Session(){
        this.expiredAt = LocalDateTime.now().plusDays(1);
    }
}
