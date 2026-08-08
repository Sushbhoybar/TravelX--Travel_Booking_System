package com.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.PaymentOrder;
import com.backend.entity.PaymentOrderStatus;

public interface PaymentOrderRepository
        extends JpaRepository<PaymentOrder, Long> {

    Optional<PaymentOrder>
    findByRazorpayOrderId(String razorpayOrderId);

    Optional<PaymentOrder>
    findByBookingId(Long bookingId);

    boolean existsByBookingIdAndStatus(
            Long bookingId,
            PaymentOrderStatus status);
}