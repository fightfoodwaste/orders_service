package com.fightfoodwaste.order_service.service;


import com.fightfoodwaste.order_service.dto.CreateOrderRequest;

public interface OrderService {

    void createOrder(CreateOrderRequest request);
}
