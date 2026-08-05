package com.busbooking.dtos;

import com.busbooking.entities.BusStatus;
import com.busbooking.entities.BusType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminBusResponse {

    private Long busId;

    private String agencyName;

    private String registrationNumber;

    private String busName;

    private BusType busType;

    private Integer totalSeats;

    private BusStatus status;

}