package net.javaguides.springboot_transaction_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String Type;
    @Column(nullable = false)
    private String cardName;
    @Column(nullable = false)
    private String cardNumber;
    @Column(nullable = false)
    private int expiryYear;
    @Column(nullable = false)
    private int expiryMonth;
    @Column(nullable = false)
    private int cvc;
    @Column(nullable = false)
    private Long orderId;
}
