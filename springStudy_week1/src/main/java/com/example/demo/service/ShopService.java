package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.domain.Shop;
import com.example.demo.domain.ShopRepository;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {

        this.shopRepository = shopRepository;
    }

//    public void shopOrder(int quantity, Category category){
//        goodsService.addGoods(100 * quantity, category);
//        Shop shop = shopRepository.findById(1L).orElseThrow(null);
//        int goodsPrice = 10000;
//        int orderPrice = goodsPrice * quantity;
//        int countDiscount = 0;
//        if (quantity >= 10){
//            countDiscount =  quantity / 10;
//            orderPrice -= countDiscount * 25000;
//        }
//        if (shop.getBudget() >= orderPrice){
//            shop.order(orderPrice);
//        }
//    }
}
