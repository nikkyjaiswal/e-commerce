package net.javaguides.springboot_transaction_demo.dto;

import lombok.Getter;
import lombok.Setter;
import net.javaguides.springboot_transaction_demo.entity.Order;
import net.javaguides.springboot_transaction_demo.entity.Payment;
@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
