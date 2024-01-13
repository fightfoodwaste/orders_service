package com.fightfoodwaste.order_service.service;

import com.fightfoodwaste.order_service.config.MessagingConfig;
import com.fightfoodwaste.order_service.dto.StockVerifiedMessage;
import com.fightfoodwaste.order_service.enums.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConsumingServiceImpl implements ConsumingService{

    private final OrderService orderService;

    @Override
    @RabbitListener(queues = MessagingConfig.STOCK_VERIFIED_QUEUE_NAME)
    public void consumeStockVerification(StockVerifiedMessage payload) {
        UUID order_id = UUID.fromString(payload.getOrder_id());
        if(payload.isAvailable()){
            orderService.updateStatus(order_id, OrderStatus.COMPLETE);
        }
        else{
            orderService.updateStatus(order_id, OrderStatus.CANCELED);
        }
    }
}
