package com.backend.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "payment_orders",
    indexes = {
        @Index(name = "idx_booking_id", columnList = "booking_id"),
        @Index(name = "idx_razorpay_order_id", columnList = "razorpay_order_id")
    }
)
@Getter
@Setter
@NoArgsConstructor
public class PaymentOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_id", nullable = false)
    private Long bookingId;

    @Column(
        name = "razorpay_order_id",
        nullable = false,
        unique = true
    )
    private String razorpayOrderId;

    @Column(
        name = "amount",
        nullable = false,
        precision = 12,
        scale = 2
    )
    private BigDecimal amount;

    @Column(
        name = "currency",
        nullable = false,
        length = 10
    )
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(
        name = "status",
        nullable = false,
        length = 30
    )
    private PaymentOrderStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}