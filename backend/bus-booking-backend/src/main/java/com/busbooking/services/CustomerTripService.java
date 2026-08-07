package com.busbooking.services;

import java.util.List;

import com.busbooking.dtos.CustomerTripDetailsResponse;
import com.busbooking.dtos.CustomerTripResponse;
import com.busbooking.dtos.SearchTripRequest;
import com.busbooking.dtos.TripSeatLayoutResponse;

public interface CustomerTripService {

    List<CustomerTripResponse> searchTrips(
            SearchTripRequest request);

    CustomerTripDetailsResponse getTripDetails(
            Long tripId);

    TripSeatLayoutResponse getTripSeatLayout(Long tripId);
}