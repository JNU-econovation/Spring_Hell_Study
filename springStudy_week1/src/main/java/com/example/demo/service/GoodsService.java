package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.domain.Goods;
import com.example.demo.domain.GoodsRepository;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    private final GoodsRepository goodsRepository;

    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }
//    private int quantity;
//
//    private Category category;
    public void saveGoods(Category category){
        Goods goods = Goods.builder()
                .category(category)
                .build();
        goodsRepository.save(goods);
    }

    public void addGoods(int quantity, Category category){
        Goods goods = goodsRepository.findByCategory(category);
        goods.addQuantity(quantity);
    }

//    public void subGoods(int quantity, Category category){
//        Goods goods = goodsRepository.findByCategory(category);
//        goods.addQuantity(quantity);
//    }
}
