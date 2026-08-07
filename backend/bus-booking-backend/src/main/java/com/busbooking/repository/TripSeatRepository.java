package com.busbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busbooking.entities.Seat;
import com.busbooking.entities.Trip;
import com.busbooking.entities.TripSeat;

public interface TripSeatRepository extends JpaRepository<TripSeat, Long> {

    List<TripSeat> findByTripOrderBySeatRowNoAscSeatColumnNoAsc(Trip trip);

    List<TripSeat> findByTripTripIdOrderBySeatRowNoAscSeatColumnNoAsc(Long tripId);

    boolean existsByTripAndSeat(Trip trip, Seat seat);

    long countByTrip(Trip trip);
    
    List<TripSeat> findByTripTripIdOrderBySeatDeckAscSeatRowNoAscSeatColumnNoAsc(
            Long tripId);

}