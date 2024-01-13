package com.fightfoodwaste.order_service.service;

import com.fightfoodwaste.order_service.dto.VerifyStockMessage;

public interface PublishingService {

    void publishToSave(VerifyStockMessage payload);
}
