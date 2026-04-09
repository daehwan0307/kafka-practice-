package org.daehwan.kafkapractice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {
    @KafkaListener(topics = "order-topic", groupId = "kafka-practice-group")
    public void consume(String message) {
        log.info("Consuming order message: {}", message);
    }
}
