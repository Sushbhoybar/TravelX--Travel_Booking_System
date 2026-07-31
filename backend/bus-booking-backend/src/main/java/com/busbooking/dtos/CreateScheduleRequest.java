package com.busbooking.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateScheduleRequest {

    @NotNull
    private Long busId;

    @NotNull
    private Long routeId;

    @NotNull
    private LocalDate journeyDate;

    @NotNull
    private LocalTime departureTime;

    @NotNull
    private LocalTime arrivalTime;

    @NotNull
    private BigDecimal fare;

    @NotNull
    private Integer availableSeats;

}