package net.javaguides.springboot_transaction_demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String orderTrackingNumber;
    @Column(nullable = false)
    private int totalquantity;
    @Column(nullable = false)
    private BigDecimal totalPrice;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private LocalDateTime dateCreated;
    @Column(nullable = false)
    private LocalDateTime lastUpdated;
    @Column(nullable = false)
    private Long shoppingCartId;

}
