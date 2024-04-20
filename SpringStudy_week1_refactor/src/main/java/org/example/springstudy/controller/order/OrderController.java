package org.example.springstudy.controller.order;

import lombok.RequiredArgsConstructor;
import org.example.springstudy.dto.order.request.CityHallUserOrderDTO;
import org.example.springstudy.dto.order.request.FestivalUserOrderDTO;
import org.example.springstudy.service.order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order/cityHallUser")
    public void OrderByCityHallUser(@RequestBody CityHallUserOrderDTO cityHallUserOrderDTO){
        orderService.CityHallUserOrder(cityHallUserOrderDTO);
    }

    @PostMapping("/order/festivalUser")
    public void OrderByCityHallUser(@RequestBody FestivalUserOrderDTO festivalUserOrderDTO){
        orderService.FestivalUserOrder(festivalUserOrderDTO);
    }
}
