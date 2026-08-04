package com.busbooking.services;

import java.util.List;

import com.busbooking.dtos.AddBusRequest;
import com.busbooking.dtos.AgentBusDetailsResponse;
import com.busbooking.dtos.AgentBusResponse;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.BusDetailsResponse;
import com.busbooking.dtos.BusResponse;
import com.busbooking.dtos.UpdateBusRequest;

public interface BusService {

    ApiResponse addBus(AddBusRequest request,
                       String email);

    BusDetailsResponse getBusDetails(
            Long busId,
            String email);

    ApiResponse updateBus(
            Long busId,
            UpdateBusRequest request,
            String email);

    ApiResponse deleteBus(
            Long busId,
            String email);

    List<AgentBusResponse> getMyBuses(
            String email);

    AgentBusDetailsResponse getBus(
            Long busId,
            String email);
    
    

}