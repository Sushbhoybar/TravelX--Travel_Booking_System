package com.busbooking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.busbooking.entities.Trip;
import com.busbooking.entities.TripStatus;

public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findByBusAgentUserId(Long userId);

    List<Trip> findByTripStatusAndDepartureDateTimeBefore(
            TripStatus tripStatus,
            LocalDateTime departureDateTime);

}