package com.busbooking.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTripRequest {

    @NotNull(message = "Bus is required")
    private Long busId;

    @NotNull(message = "Route is required")
    private Long routeId;
    
    @NotNull(message = "Arrival Date & Time is required")
    @Future(message = "Arrival time must be in future")
    private LocalDateTime arrivalDateTime;
    

    @NotNull(message = "Departure Date & Time is required")
    @Future(message = "Departure must be in future")
    private LocalDateTime departureDateTime;

    @NotNull(message = "Fare is required")
    @DecimalMin(value = "1.0", message = "Fare must be greater than 0")
    private BigDecimal baseFare;

    @NotNull(message = "Available Seats is required")
    @Min(value = 1, message = "Available seats must be greater than 0")
    private Integer availableSeats;

}