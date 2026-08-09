package com.busbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busbooking.entities.Booking;
import com.busbooking.entities.BookingSeat;
import com.busbooking.entities.TripSeat;

public interface BookingSeatRepository
        extends JpaRepository<BookingSeat, Long> {

    List<BookingSeat> findByBooking(
            Booking booking
    );

    boolean existsByBookingAndTripSeat(
            Booking booking,
            TripSeat tripSeat
    );

    boolean existsByTripSeat(
            TripSeat tripSeat
    );

    long countByBooking(
            Booking booking
    );
}