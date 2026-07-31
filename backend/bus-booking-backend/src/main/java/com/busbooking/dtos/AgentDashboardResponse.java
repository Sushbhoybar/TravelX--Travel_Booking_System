package com.busbooking.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AgentDashboardResponse {

    private Long totalBuses;

    private Long approvedBuses;

    private Long pendingBuses;

    private Long rejectedBuses;

    private Long totalTrips;

    private Long totalBookings;

}