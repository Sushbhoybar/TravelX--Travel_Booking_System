package com.busbooking.dtos;

import com.busbooking.entities.BusStatus;
import com.busbooking.entities.BusType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusResponse {

    private Long busId;

    private String busName;

    private String registrationNumber;

    private BusType busType;

    private Integer totalSeats;

    private BusStatus status;

}