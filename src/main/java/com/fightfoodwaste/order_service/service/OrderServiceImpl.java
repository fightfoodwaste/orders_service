package com.fightfoodwaste.order_service.service;

import com.fightfoodwaste.order_service.dto.CreateOrderRequest;
import com.fightfoodwaste.order_service.dto.OrderCreatedMessage;
import com.fightfoodwaste.order_service.entity.OrderEntity;
import com.fightfoodwaste.order_service.repository.OrdersRepository;
import com.fightfoodwaste.order_service.utility.ObjConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        OrderCreatedMessage payload = converter.generateOrderCreatedPayload(entity);
        publishingService.publishToSave(payload);
    }
}
