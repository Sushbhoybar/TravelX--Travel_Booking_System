package com.busbooking.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.busbooking.entities.TripStatus;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripRequest {

    @NotNull
    private Long busId;

    @NotNull
    private Long routeId;

    @NotBlank
    private String boardingPoint;

    @NotBlank
    private String droppingPoint;

    @NotNull
    @Future
    private LocalDateTime departureDateTime;

    @NotNull
    private LocalDateTime arrivalDateTime;

    @NotNull
    private BigDecimal fare;

    private TripStatus status;
}