package com.busbooking.services;

import java.util.List;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.CreateTripRequest;
import com.busbooking.dtos.RouteResponse;
import com.busbooking.dtos.AgentBusResponse;
import com.busbooking.dtos.TripDetailsResponse;
import com.busbooking.dtos.TripResponse;

public interface TripService {

    ApiResponse createTrip(CreateTripRequest request, String email);

    List<TripResponse> getMyTrips(String email);

    TripDetailsResponse getTripDetails(Long tripId, String email);

    ApiResponse cancelTrip(Long tripId, String email);

    void updateTripStatuses();
    
    List<AgentBusResponse> getApprovedBuses(String email);

    List<RouteResponse> getActiveRoutes();

}