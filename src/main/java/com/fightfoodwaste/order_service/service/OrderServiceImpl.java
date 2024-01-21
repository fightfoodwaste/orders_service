package com.fightfoodwaste.order_service.service;

import com.fightfoodwaste.order_service.dto.CreateOrderRequest;
import com.fightfoodwaste.order_service.dto.VerifyStockMessage;
import com.fightfoodwaste.order_service.entity.OrderEntity;
import com.fightfoodwaste.order_service.enums.OrderStatus;
import com.fightfoodwaste.order_service.repository.OrdersRepository;
import com.fightfoodwaste.order_service.utility.ObjConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements  OrderService {

    private final OrdersRepository repository;

    private final ObjConverter converter;

    private final PublishingService publishingService;


    @Override
    public void createOrder(CreateOrderRequest request) {
        OrderEntity entity = converter.generateOrderFromRequest(request);
        repository.save(entity);
        VerifyStockMessage payload = converter.generateOrderCreatedPayload(entity);
        //publishingService.publishToSave(payload);
        System.out.println("Awaiting stock confirmation for order #" + entity.getId());
    }

    @Override
    public void updateStatus(UUID order_id, OrderStatus status) {
        System.out.println("Order #" + order_id + " status set to " + status.toString());
        repository.updateOrderStatus(order_id, status.toString());
    }


}
