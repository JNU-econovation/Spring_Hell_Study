package com.econovation.springstudy.entity;

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

    public String getName() {
        return name;
    }

    public int getRemaining() {
        return remaining;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }


    public abstract static class GoodsBuilder<T extends GoodsBuilder<T>>{
        protected String name;
        protected int remaining;
        protected int sellingPrice;

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

        public abstract T self();
        public abstract Goods build();

    }

    public Goods(String name, int remaining, int sellingPrice) {
        this.name = name;
        this.remaining = remaining;
        this.sellingPrice = sellingPrice;
    }

    protected Goods() {
    }
}
