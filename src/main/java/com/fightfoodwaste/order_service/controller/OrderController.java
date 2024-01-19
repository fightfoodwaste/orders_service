package com.fightfoodwaste.order_service.controller;

import com.fightfoodwaste.order_service.dto.CreateOrderRequest;
import com.fightfoodwaste.order_service.service.OrderService;
import com.fightfoodwaste.order_service.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("/create")
    public ResponseEntity createOrder(@RequestBody CreateOrderRequest request){
        try {
            service.createOrder(request);
            return ResponseEntity.ok().build();

        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
