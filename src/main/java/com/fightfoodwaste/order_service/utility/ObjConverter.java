package com.fightfoodwaste.order_service.utility;

import com.fightfoodwaste.order_service.dto.CreateOrderRequest;
import com.fightfoodwaste.order_service.dto.VerifyStockMessage;
import com.fightfoodwaste.order_service.entity.OrderEntity;
import com.fightfoodwaste.order_service.enums.OrderStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class ObjConverter {
    private Long getCurrentTimestamp(){
        LocalDateTime timeNow = LocalDateTime.now();
        ZoneOffset zoneOffset = ZoneOffset.of("+01:00");
        ZonedDateTime zonedDateTime = timeNow.atOffset(zoneOffset).toZonedDateTime();
        return zonedDateTime.toInstant().toEpochMilli();
    }
    public OrderEntity generateOrderFromRequest(CreateOrderRequest request){
        System.out.println(request);
        OrderEntity entity = new OrderEntity();
        entity.setId(UUID.randomUUID());
        entity.setAccount_id(request.getAccount_id());
        entity.setProduct_id(request.getProduct_id());
        entity.setProduct_amount(request.getProduct_amount());
        entity.setStatus(OrderStatus.PENDING_STOCK);
        entity.setTimestamp(getCurrentTimestamp());
        return entity;
    }

    public VerifyStockMessage generateOrderCreatedPayload(OrderEntity entity){
        return new VerifyStockMessage(entity.getId().toString(), entity.getProduct_id(), entity.getProduct_amount());
    }
}
