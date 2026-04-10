package org.daehwan.kafkapractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;
    private String productName;
    private int quantity;
    private int price;
}
