package com.busbooking.services;

import java.util.List;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.TripDetailsResponse;
import com.busbooking.dtos.TripRequest;
import com.busbooking.dtos.TripResponse;

public interface TripService {

    ApiResponse createTrip(
            TripRequest request,
            String email);

    List<TripResponse> getMyTrips(
            String email);

    TripDetailsResponse getTrip(
            Long tripId);

    ApiResponse updateTrip(
            Long tripId,
            TripRequest request);

    ApiResponse deleteTrip(
            Long tripId);

}