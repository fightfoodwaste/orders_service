package com.fightfoodwaste.order_service.service;

import com.fightfoodwaste.order_service.config.MessagingConfig;
import com.fightfoodwaste.order_service.dto.OrderCreatedMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishingServiceImpl implements PublishingService{

    private final RabbitTemplate rabbitTemplate;
    @Override
    public void publishToSave(OrderCreatedMessage payload) {
        rabbitTemplate.convertAndSend(MessagingConfig.ORDERS_EXCHANGE_NAME, MessagingConfig.ORDER_CREATED_ROUTING_KEY, payload);
        System.out.println("Message Published!");
    }
}
