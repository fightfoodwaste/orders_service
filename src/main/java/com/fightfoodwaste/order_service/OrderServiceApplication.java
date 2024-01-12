package com.fightfoodwaste.order_service;

import com.fightfoodwaste.order_service.entity.OrderEntity;
import com.fightfoodwaste.order_service.enums.OrderStatus;
import com.fightfoodwaste.order_service.repository.OrdersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.LocalDateTime;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
