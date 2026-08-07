package com.busbooking.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.busbooking.entities.BusStatus;
import com.busbooking.entities.Trip;
import com.busbooking.entities.TripStatus;

public interface TripRepository extends JpaRepository<Trip, Long> {

    // ===========================================
    // Agent
    // ===========================================

    List<Trip> findByBusAgentUserId(Long userId);

    List<Trip> findByTripStatusAndDepartureDateTimeBefore(
            TripStatus tripStatus,
            LocalDateTime departureDateTime);
    
    

    // ===========================================
    // Customer - Search Trips
    // ===========================================

    @Query("""
    	    SELECT t
    	    FROM Trip t
    	    WHERE t.tripStatus = :tripStatus
    	      AND t.bus.status = :busStatus
    	      AND t.availableSeats > 0
    	      AND LOWER(t.route.sourceCity) = LOWER(:sourceCity)
    	      AND LOWER(t.route.destinationCity) = LOWER(:destinationCity)
    	      AND t.departureDateTime BETWEEN :startDateTime AND :endDateTime
    	    ORDER BY t.departureDateTime ASC
    	    """)
    List<Trip> searchTrips(
            String sourceCity,
            String destinationCity,
            LocalDateTime startDateTime,
            LocalDateTime endDateTime,
            TripStatus tripStatus,
            BusStatus busStatus);

    // ===========================================
    // Customer - Trip Details
    // ===========================================

    @Query("""
            SELECT t
            FROM Trip t
            JOIN FETCH t.bus
            JOIN FETCH t.route
            WHERE t.tripId = :tripId
            AND t.tripStatus = :tripStatus
            AND t.bus.status = :busStatus
            """)
    Optional<Trip> findCustomerTripById(
            Long tripId,
            TripStatus tripStatus,
            BusStatus busStatus);

}