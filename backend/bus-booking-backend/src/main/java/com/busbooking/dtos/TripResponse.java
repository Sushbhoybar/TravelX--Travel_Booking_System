package com.busbooking.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.busbooking.entities.TripStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripResponse {

    private Long tripId;

    private String busName;

    private String registrationNumber;

    private String sourceCity;

    private String destinationCity;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

    private BigDecimal baseFare;

    private Integer availableSeats;

    private TripStatus tripStatus;

}