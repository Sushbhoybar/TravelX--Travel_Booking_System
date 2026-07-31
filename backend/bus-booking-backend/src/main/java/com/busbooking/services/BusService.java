package com.busbooking.services;

import java.util.List;

import com.busbooking.dtos.AddBusRequest;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.BusDetailsResponse;
import com.busbooking.dtos.BusResponse;
import com.busbooking.dtos.UpdateBusRequest;

public interface BusService {

    ApiResponse addBus(AddBusRequest request,
                       String email);

    List<BusResponse> getMyBuses(String email);

    BusDetailsResponse getBusDetails(Long busId);

    ApiResponse updateBus(Long busId,
            UpdateBusRequest request);

    ApiResponse deleteBus(Long busId);

}