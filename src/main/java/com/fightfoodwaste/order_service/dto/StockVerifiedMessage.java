package com.fightfoodwaste.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockVerifiedMessage {
    private String order_id;
    private boolean available;
}
