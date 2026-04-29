package org.daehwan.kafkapractice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.daehwan.kafkapractice.dto.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
public class OrderConsumer {
    private final Set<String> processedOrderIds = Collections.synchronizedSet(new HashSet<>());

    @KafkaListener(topics = "order-topic", groupId = "kafka-practice-group")
    public void consume(Order order, @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {

        if (processedOrderIds.contains(order.getOrderId())) {
            log.warn("중복 메시지 무시: orderId={}", order.getOrderId());
            return;
        }

        if (order.getOrderId().equals("9999")) {
            throw new RuntimeException("주문 처리 실패! orderId: " + order.getOrderId());
        }

        log.info("Consuming order message: {} | partition: {}", order, partition);
        processedOrderIds.add(order.getOrderId());
    }
}
