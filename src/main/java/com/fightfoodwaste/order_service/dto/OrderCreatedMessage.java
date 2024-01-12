package com.fightfoodwaste.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedMessage {

    private UUID order_id;
    private Long product_id;
    private int product_amount;

}
