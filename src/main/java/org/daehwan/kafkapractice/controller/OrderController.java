package org.daehwan.kafkapractice.controller;

import lombok.RequiredArgsConstructor;
import org.daehwan.kafkapractice.producer.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping
    public String order(@RequestParam String orderId) {
        orderProducer.sendOrder(orderId);
        return "Order sent: " + orderId;
    }
}
