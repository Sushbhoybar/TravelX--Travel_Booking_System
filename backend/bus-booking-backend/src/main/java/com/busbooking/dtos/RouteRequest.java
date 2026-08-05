package com.busbooking.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteRequest {

    @NotBlank
    private String sourceCity;

    @NotBlank
    private String destinationCity;

    @NotNull
    @Min(1)
    private Integer distanceKm;

    @NotNull
    @Min(1)
    private Integer estimatedDurationMinutes;

    @NotNull
    private Boolean active;
}