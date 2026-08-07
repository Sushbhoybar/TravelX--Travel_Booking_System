package com.busbooking.dtos;

import java.math.BigDecimal;
import java.util.List;

import com.busbooking.entities.BusType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TripSeatLayoutResponse {

    private Long tripId;

    private String busName;

    private BusType busType;

    private Integer totalSeats;

    private Integer availableSeats;

    private BigDecimal fare;

    private List<SeatLayoutResponse> seats;

}