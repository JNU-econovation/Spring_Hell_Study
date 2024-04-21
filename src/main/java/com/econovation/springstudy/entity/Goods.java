package com.econovation.springstudy.entity;

import com.econovation.springstudy.config.enums.GoodsType;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private int remaining;
    @Column(nullable = false)
    private int sellingPrice;
    @Column(nullable = false)
    private GoodsType goodsType;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRemaining() {
        return remaining;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }
    private void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public void addRemaining(int quantityToAdd){
        if (quantityToAdd <= 0) throw new IllegalArgumentException("1개 이상 입력");
        setRemaining(this.remaining + quantityToAdd);
    }
    public void deductRemaining(int quantityToDeduct){
        if (quantityToDeduct <= 0) throw new IllegalArgumentException("1개 이상 입력");
        if (this.remaining - quantityToDeduct < 0) throw new IllegalArgumentException("재고가 부족합니다");
        setRemaining(this.remaining - quantityToDeduct);
    }

    public abstract static class GoodsBuilder<T extends GoodsBuilder<T>>{
        protected String name;
        protected int remaining;
        protected int sellingPrice;
        protected GoodsType goodsType;

        public T name(String name){
            this.name = name;
            return self();
        }
        public T remaining(int remaining){
            this.remaining = remaining;
            return self();
        }
        public T sellingPrice(int sellingPrice){
            this.sellingPrice = sellingPrice;
            return self();
        }
        public T goodsType(GoodsType goodsType){
            this.goodsType = goodsType;
            return self();
        }

        public abstract T self();
        public abstract Goods build();

    }

    public Goods(String name, int remaining, int sellingPrice, GoodsType goodsType) {
        this.name = name;
        this.remaining = remaining;
        this.sellingPrice = sellingPrice;
        this.goodsType = goodsType;
    }

    protected Goods() {
    }
}
