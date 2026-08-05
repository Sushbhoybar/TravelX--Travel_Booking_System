package com.busbooking.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminDashboardResponse {

    private long totalUsers;

    private long totalCustomers;

    private long totalAgents;

    private long totalBuses;

    private long pendingBuses;

    private long approvedBuses;

    private long rejectedBuses;

}