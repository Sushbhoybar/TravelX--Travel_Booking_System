package com.busbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busbooking.entities.Booking;
import com.busbooking.entities.BookingPassenger;

public interface BookingPassengerRepository
        extends JpaRepository<BookingPassenger, Long> {

    List<BookingPassenger> findByBooking(
            Booking booking
    );

    long countByBooking(
            Booking booking
    );
}