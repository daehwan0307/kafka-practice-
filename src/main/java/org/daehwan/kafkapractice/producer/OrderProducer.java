package org.daehwan.kafkapractice.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "order-topic";

    public void sendOrder(String orderId) {
        log.info("Producing order message: {}", orderId);
        kafkaTemplate.send(TOPIC, orderId);
    }
}