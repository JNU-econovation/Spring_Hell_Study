package com.econovation.springstudy.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class GoodsController {

    // spring bean에 등록하지 않아 사용 불가능
    // @Autowired private GoodsService goodsService;

    private final GoodsService goodsService;
    public GoodsController(){
        this.goodsService = new GoodsServiceImpl();
    }

    // goods 생성 api
    @PostMapping("/goods")
    public ResponseEntity<String> createGoods(@RequestBody NamwonGoods namwonGoods){
        BaseGoods goods = new NamwonGoods(namwonGoods.getId(),namwonGoods.getName(), namwonGoods.getPrice(),namwonGoods.getStock());
        goodsService.createGoods(goods);
        return new ResponseEntity<>("Goods 생성 성공", HttpStatus.CREATED);
    }

    // 각 상품의 재고 확인
    @GetMapping("/goods/{id}")
    public ResponseEntity<Integer> getGoodsStock(@PathVariable Long id){
        // 요청시 500 에러, 생성된 객체가 없어서 nullPointerException
        BaseGoods goods = goodsService.findGoodsById(id);
        if (goods == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 상품이 없는 경우 404 에러 반환
        }

        int stock = goodsService.getGoodsStock(id);
        return new ResponseEntity<>(stock,HttpStatus.OK);
    }

}
