package com.busbooking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busbooking.entities.Booking;
import com.busbooking.entities.User;

public interface BookingRepository
        extends JpaRepository<Booking, Long> {

    Optional<Booking> findByBookingReference(
            String bookingReference
    );

    Optional<Booking> findByRazorpayOrderId(
            String razorpayOrderId
    );

    boolean existsByRazorpayOrderId(
            String razorpayOrderId
    );

    boolean existsByPaymentId(
            String paymentId
    );

    long countByUser(User user);
}