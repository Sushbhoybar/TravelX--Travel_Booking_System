package com.busbooking.services;

import com.busbooking.dtos.AdminLoginRequest;
import com.busbooking.dtos.AdminLoginResponse;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.BusDetailsResponse;
import com.busbooking.dtos.FeedbackResponse;


import java.util.List;

import com.busbooking.dtos.BusResponse;
import com.busbooking.dtos.UserResponse;


public interface AdminService {

    AdminLoginResponse login(AdminLoginRequest request);
    
    List<UserResponse> getAllUsers();
    
    ApiResponse blockUser(Long userId);

    ApiResponse unblockUser(Long userId);
    
    ApiResponse deleteUser(Long userId);
    
    List<BusResponse> getAllBuses();
    
    BusDetailsResponse getBusById(Long busId);

    ApiResponse approveBus(Long busId);

    ApiResponse rejectBus(Long busId);
    
    List<FeedbackResponse> getAllFeedback();

}