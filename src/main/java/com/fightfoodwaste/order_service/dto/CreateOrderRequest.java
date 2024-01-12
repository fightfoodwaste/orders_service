package com.fightfoodwaste.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private long product_id;
    private long account_id;
    private int product_amount;
}
