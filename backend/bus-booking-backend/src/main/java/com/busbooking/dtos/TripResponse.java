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

    private Long busId;

    private String busName;

    private Long routeId;

    private String source;

    private String destination;

    private String boardingPoint;

    private String droppingPoint;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

    private BigDecimal fare;

    private TripStatus status;

}