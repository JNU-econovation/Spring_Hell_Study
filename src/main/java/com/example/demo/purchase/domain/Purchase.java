package com.example.demo.purchase.domain;

import com.example.demo.sticker.domain.Sticker;
import com.example.demo.user.domain.User;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "purchase")
@Getter
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sticker_id")
    Sticker sticker;

    @Column
    Integer quantity;
}
