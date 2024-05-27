package net.javaguides.springboot_transaction_demo.service;

import net.javaguides.springboot_transaction_demo.dto.OrderRequest;
import net.javaguides.springboot_transaction_demo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);

}
