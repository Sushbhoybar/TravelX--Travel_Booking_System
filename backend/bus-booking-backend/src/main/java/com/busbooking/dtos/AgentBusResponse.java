package com.busbooking.dtos;

import com.busbooking.entities.BusStatus;
import com.busbooking.entities.BusType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentBusResponse {

    private Long busId;

    private String busName;

    private String registrationNumber;

    private BusType busType;

    private Integer totalSeats;

    private BusStatus status;

    private String adminRemarks;
    
    private Boolean canEdit;
    
    private Boolean canDelete;

}