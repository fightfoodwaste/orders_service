package com.fightfoodwaste.order_service.repository;

import com.fightfoodwaste.order_service.entity.OrderEntity;
import com.fightfoodwaste.order_service.enums.OrderStatus;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface OrdersRepository extends CassandraRepository<OrderEntity, UUID> {

    @Query("UPDATE orders SET status = :status WHERE id = :order_id")
    void updateOrderStatus(@Param("order_id")UUID order_id, @Param("status")String status);
}
