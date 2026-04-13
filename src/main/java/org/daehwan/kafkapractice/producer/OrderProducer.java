package org.daehwan.kafkapractice.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.daehwan.kafkapractice.dto.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderProducer {


    private final KafkaTemplate<String, Order> kafkaTemplate;

    private static final String TOPIC = "order-topic";

    public void sendOrder(Order order) {
        log.info("Producing order message: {}", order);
        kafkaTemplate.send(TOPIC, order.getOrderId(), order);
    }
}