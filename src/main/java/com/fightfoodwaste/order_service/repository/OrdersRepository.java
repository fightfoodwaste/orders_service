package com.fightfoodwaste.order_service.repository;

import com.fightfoodwaste.order_service.entity.OrderEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepository extends CassandraRepository<OrderEntity, Long> {
}
