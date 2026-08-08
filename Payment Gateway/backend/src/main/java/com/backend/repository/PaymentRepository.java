package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.entity.Payment;

import java.util.Optional;

public interface PaymentRepository
        extends JpaRepository<Payment, Long> {

    Optional<Payment> findByRazorpayOrderId(
            String razorpayOrderId
    );

    Optional<Payment> findByRazorpayPaymentId(
            String razorpayPaymentId
    );

    Optional<Payment> findByBookingId(
            Long bookingId
    );

}