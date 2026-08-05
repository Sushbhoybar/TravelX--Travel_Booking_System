package com.busbooking.services;

import java.util.List;

import com.busbooking.dtos.AdminBusDetailsResponse;
import com.busbooking.dtos.AdminBusResponse;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.RejectBusRequest;

public interface AdminBusService {

    List<AdminBusResponse> getAllBuses();

    AdminBusDetailsResponse getBusDetails(
            Long busId);

    ApiResponse approveBus(
            Long busId);

 // aprrove bus
    ApiResponse rejectBus(
            Long busId,
            RejectBusRequest request);
    
    
    
    

}