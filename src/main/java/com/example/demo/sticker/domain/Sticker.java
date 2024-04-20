package com.example.demo.sticker.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "sticker")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Sticker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;
    private Integer stock;
    private Integer initialStock;
    private Integer price;
    @Builder
    public Sticker(String name, Integer initialStock) {
        this.name = name;
        this.initialStock = initialStock;
        this.stock = initialStock;
    }


    public Sticker(String name) {
        this.name = name;
    }

    public void updatePrice(Integer price) {this.price = price; }
}
