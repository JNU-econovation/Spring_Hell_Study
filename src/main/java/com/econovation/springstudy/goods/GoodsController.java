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
        StringBuilder responseMessage = new StringBuilder("생성된 상품들\n");
        Long id = namwonGoods.getId();
        for(GoodsRank rank : GoodsRank.values()){

            BaseGoods goods = new NamwonGoods(id++,namwonGoods.getName(),
                    namwonGoods.getPrice(), namwonGoods.getStock(),rank);
            goodsService.createGoods(goods);

            responseMessage.append("- ").append(goods.getName()).append(" ").append(rank.name()).append("\n");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage.toString());
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
