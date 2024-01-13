package com.fightfoodwaste.order_service.service;

import com.fightfoodwaste.order_service.dto.StockVerifiedMessage;

public interface ConsumingService {

    public void consumeStockVerification(StockVerifiedMessage payload);
}
