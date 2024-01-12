package com.fightfoodwaste.order_service.service;

import com.fightfoodwaste.order_service.entity.OrderEntity;
import com.fightfoodwaste.order_service.enums.OrderStatus;
import com.fightfoodwaste.order_service.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrdersRepository repository;

    public void testsave(){
        repository.save(new OrderEntity(0L, 1L, 2L, 1, OrderStatus.CREATED, LocalDateTime.now()));
    }
}
