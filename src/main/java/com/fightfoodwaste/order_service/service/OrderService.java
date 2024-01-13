package com.fightfoodwaste.order_service.service;


import com.fightfoodwaste.order_service.dto.CreateOrderRequest;
import com.fightfoodwaste.order_service.enums.OrderStatus;

import java.util.UUID;

public interface OrderService {

    void createOrder(CreateOrderRequest request);

    void updateStatus(UUID order_id, OrderStatus status);
}
