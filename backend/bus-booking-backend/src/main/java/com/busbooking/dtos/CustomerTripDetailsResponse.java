package com.busbooking.dtos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import com.busbooking.entities.BusType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerTripDetailsResponse {

    private Long tripId;

    private Long busId;

    private String busName;

    private String registrationNumber;

    private BusType busType;

    private String sourceCity;

    private String destinationCity;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

    private Long durationMinutes;

    private BigDecimal fare;

    private Integer totalSeats;

    private Integer availableSeats;

    private String amenities;

    private List<String> busImages;

    private Double averageRating;

    public void calculateDuration() {

        if (departureDateTime != null && arrivalDateTime != null) {

            durationMinutes = Duration
                    .between(departureDateTime, arrivalDateTime)
                    .toMinutes();

        }

    }

}