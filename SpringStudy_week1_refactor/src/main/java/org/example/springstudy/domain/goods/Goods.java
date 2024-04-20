package org.example.springstudy.domain.goods;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goods_id")
    private Long id;
    private int price;
    @Builder.Default
    private int stockQuantity = 0;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public void addStockQuantity(int stockQuantity){
        this.stockQuantity += stockQuantity;
    }
    public void subStockQuantity(int stockQuantity){
        this.stockQuantity -= stockQuantity;
    }
}
