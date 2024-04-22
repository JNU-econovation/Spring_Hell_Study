package com.econovation.springstudy.order;

import com.econovation.springstudy.goods.BaseGoods;
import com.econovation.springstudy.order.OrderService;
import com.econovation.springstudy.order.OrderServiceImpl;
import com.econovation.springstudy.goods.NamwonGoods;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    private final OrderService orderService;
    public OrderController(){
        this.orderService = new OrderServiceImpl();
    }

    // goods 랜덤 판매
    @PostMapping("/order")
    public ResponseEntity<String> sellGoods(){
        Random random = new Random();
        orderService.sellGoods(random.nextInt(2)+1);
        return new ResponseEntity<>("랜덤 상품 판매 완료", HttpStatus.OK);
    }

    // 특정 goods의 재고 추가
    // url만 바꿔주면 값이 변경될 우려가 있지 않을까 싶다..
    @PostMapping("/order/{id}/{quantity}")
    public ResponseEntity<Integer> addGoodsStock(@PathVariable Long id,@PathVariable int quantity){
        orderService.addGoodsStock(id,quantity);
        return new ResponseEntity<>(quantity,HttpStatus.OK);
    }

}
