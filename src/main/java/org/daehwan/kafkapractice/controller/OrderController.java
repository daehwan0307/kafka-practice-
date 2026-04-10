package org.daehwan.kafkapractice.controller;

import lombok.RequiredArgsConstructor;
import org.daehwan.kafkapractice.dto.Order;
import org.daehwan.kafkapractice.producer.OrderProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping
    public String order(@RequestBody Order order) {
        orderProducer.sendOrder(order);
        return "Order sent: " + order.getOrderId();
    }
}
