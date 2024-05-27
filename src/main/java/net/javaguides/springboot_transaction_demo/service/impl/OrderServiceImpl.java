package net.javaguides.springboot_transaction_demo.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.javaguides.springboot_transaction_demo.dto.OrderRequest;
import net.javaguides.springboot_transaction_demo.dto.OrderResponse;
import net.javaguides.springboot_transaction_demo.entity.Order;
import net.javaguides.springboot_transaction_demo.entity.Payment;
import net.javaguides.springboot_transaction_demo.exception.PaymentException;
import net.javaguides.springboot_transaction_demo.repository.OrderRepository;
import net.javaguides.springboot_transaction_demo.repository.PaymentRepository;
import net.javaguides.springboot_transaction_demo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor

public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;


    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("InProcessing");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();
        if (!payment.getType().equals("Debit")) {
            throw new PaymentException("the card type is not supported");

        }
        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse= new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("Sucess");
        return orderResponse;

    }
}
