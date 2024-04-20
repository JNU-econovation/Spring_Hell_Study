package com.example.demo.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "users")
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
