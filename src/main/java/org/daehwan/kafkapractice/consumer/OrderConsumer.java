package org.daehwan.kafkapractice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.daehwan.kafkapractice.dto.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderConsumer {
    @KafkaListener(topics = "order-topic", groupId = "kafka-practice-group")
    public void consume(Order order, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        log.info("Consuming order message: {} | partition: {}", order, partition);
    }
}
