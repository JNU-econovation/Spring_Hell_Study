package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private Long id;

    @Builder.Default
    private int budget = 1000000;

    @OneToMany
    private List<Goods> goodsList;

    public void order(int totalMoney){
        this.budget -= totalMoney;
    }
}
