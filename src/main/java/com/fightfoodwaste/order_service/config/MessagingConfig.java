package com.fightfoodwaste.order_service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {
    public static final String ORDER_CREATED_QUEUE_NAME = "order-created";
    public static final String ORDERS_EXCHANGE_NAME = "orders-exchange";
    public static final String ORDER_CREATED_ROUTING_KEY = "order-created";

    @Bean
    org.springframework.amqp.core.Queue order_created_queue() {
        return new org.springframework.amqp.core.Queue(ORDER_CREATED_QUEUE_NAME, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(ORDERS_EXCHANGE_NAME);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ORDER_CREATED_ROUTING_KEY);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(CachingConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}


