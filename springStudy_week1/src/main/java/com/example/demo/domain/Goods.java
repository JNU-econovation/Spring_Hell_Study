package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private Long id;
    @Builder.Default
    private int quantity = 0;
    @Builder.Default
    private int price = 10000;

    private Category category;

    public void addQuantity(int addQuantity){
        this.quantity += addQuantity;
    }
    public void subQuantity(int addQuantity){
        this.quantity -= addQuantity;
    }
}
