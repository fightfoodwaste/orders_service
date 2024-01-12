package com.fightfoodwaste.order_service.service;

import com.fightfoodwaste.order_service.dto.OrderCreatedMessage;

public interface PublishingService {

    void publishToSave(OrderCreatedMessage payload);
}
