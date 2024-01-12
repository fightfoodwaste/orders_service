package com.fightfoodwaste.order_service.entity;

import com.fightfoodwaste.order_service.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("orders")
public class OrderEntity {

    @PrimaryKey
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long product_id;
    private Long account_id;
    private int product_amount;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    private LocalDateTime timestamp;
}
