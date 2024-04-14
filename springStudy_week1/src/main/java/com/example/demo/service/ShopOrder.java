package com.example.demo.service;

import com.example.demo.domain.*;
import org.springframework.stereotype.Component;

@Component
public class ShopOrder {
    private final ShopRepository shopRepository;
    private final GoodsService goodsService;

    public ShopOrder(ShopRepository shopRepository, GoodsService goodsService) {
        this.shopRepository = shopRepository;

        this.goodsService = goodsService;
    }

        public void order(int quantity, Category category){
        goodsService.addGoods(100 * quantity, category);
        Shop shop = shopRepository.findById(1L).orElseThrow(null);
        // goodsService.findGoodsByCategory()
        int goodsPrice = 10000;
        int orderPrice = goodsPrice * quantity;
        int countDiscount = 0;
        if (quantity >= 10){
            countDiscount =  quantity / 10;
            orderPrice -= countDiscount * 25000;
        }
        if (shop.getBudget() >= orderPrice){
            shop.order(orderPrice);
        } else{
        }
    }
}
