package com.fightfoodwaste.order_service.controller;

import com.fightfoodwaste.order_service.dto.CreateOrderRequest;
import com.fightfoodwaste.order_service.service.OrderService;
import com.fightfoodwaste.order_service.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public ResponseEntity createOrder(CreateOrderRequest request){
        try {
            service.createOrder(request);
            return ResponseEntity.ok().build();

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
