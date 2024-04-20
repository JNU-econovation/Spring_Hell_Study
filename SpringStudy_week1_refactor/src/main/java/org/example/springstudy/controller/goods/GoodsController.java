package org.example.springstudy.controller.goods;

import lombok.RequiredArgsConstructor;
import org.example.springstudy.domain.goods.Goods;
import org.example.springstudy.dto.goods.request.CreateCategoryDTO;
import org.example.springstudy.dto.goods.request.CreateGoodsDTO;
import org.example.springstudy.service.goods.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequiredArgsConstructor
public class GoodsController {
    private final GoodsService goodsService;

    @PostMapping("/new/category")
    public void createCategory(@RequestBody CreateCategoryDTO createCategoryDTO){
        goodsService.createCategory(createCategoryDTO);
    }

    @PostMapping("/new/goods")
    public void createGoods(@RequestBody CreateGoodsDTO createGoodsDTO){
        goodsService.createGoods(createGoodsDTO);
    }

    @GetMapping("/goods/{categoryName}")
    public int readGoods(@PathVariable("categoryName") String categoryName){
        return goodsService.findCategory(categoryName).getGoods().getStockQuantity();
    }


}
