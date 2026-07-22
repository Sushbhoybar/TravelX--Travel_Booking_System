package com.busbooking.dtos;

import com.busbooking.entities.BusStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BusDetailsResponse {

    private Long busId;
    private String busName;
    private String agentName;
    private String numberPlate;
    private String busType;
    private Integer totalSeats;
    private String route;
    private String imageUrl;
    private BusStatus status;

}