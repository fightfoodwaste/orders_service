package com.fightfoodwaste.order_service.entity;

import com.fightfoodwaste.order_service.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("orders")
public class OrderEntity {

    @Id
    @PrimaryKey
    @GeneratedValue(generator = "UUID")
    @Column("id")
    private UUID id;
    @Column("product_id")
    private Long product_id;
    @Column("account_id")
    private Long account_id;
    @Column("product_amount")
    private int product_amount;
    @Enumerated(EnumType.STRING)
    @Column("status")
    private OrderStatus status;
    @Column("timestamp")
    private Long timestamp;
}
