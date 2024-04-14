package com.example.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class OrderItems {
    @ManyToOne
    private Order order;
    @ManyToOne
    private Goods goods;
}
