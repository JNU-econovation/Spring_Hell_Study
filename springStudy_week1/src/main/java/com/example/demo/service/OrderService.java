package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.domain.DiscountPolicy;
import com.example.demo.domain.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final DiscountPolicy discountPolicy;
    private final ShopOrder shopOrder;
    private final UserOrder userOrder;


    public OrderService(OrderRepository orderRepository, DiscountPolicy discountPolicy, ShopOrder shopOrder, UserOrder userOrder) {
        this.orderRepository = orderRepository;
        this.discountPolicy = discountPolicy;
        this.shopOrder = shopOrder;
        this.userOrder = userOrder;
    }

    public void shopOrder(int quantity, Category category){
        shopOrder.order(quantity, category);
    }

    public void userOrder(int quantity){
        userOrder.order();
    }
}
