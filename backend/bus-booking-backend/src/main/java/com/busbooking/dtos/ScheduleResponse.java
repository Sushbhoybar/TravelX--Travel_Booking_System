package com.busbooking.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleResponse {

    private Long scheduleId;

    private Long busId;

    private String busName;

    private Long routeId;

    private String source;

    private String destination;

    private LocalDate journeyDate;

    private LocalTime departureTime;

    private LocalTime arrivalTime;

    private BigDecimal fare;

    private Integer availableSeats;

    private String status;

}