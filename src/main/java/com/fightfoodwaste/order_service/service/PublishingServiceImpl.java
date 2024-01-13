package com.fightfoodwaste.order_service.service;

import com.fightfoodwaste.order_service.config.MessagingConfig;
import com.fightfoodwaste.order_service.dto.VerifyStockMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublishingServiceImpl implements PublishingService{

    private final RabbitTemplate rabbitTemplate;
    @Override
    public void publishToSave(VerifyStockMessage payload) {
        rabbitTemplate.convertAndSend(MessagingConfig.VERIFY_STOCK_EXCHANGE_NAME, MessagingConfig.VERIFY_STOCK_ROUTING_KEY, payload);
    }
}
