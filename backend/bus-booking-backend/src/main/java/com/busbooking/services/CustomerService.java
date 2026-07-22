package com.busbooking.services;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.ChangePasswordRequest;
import com.busbooking.dtos.CustomerProfileResponse;
import com.busbooking.dtos.UpdateProfileRequest;

public interface CustomerService {

    CustomerProfileResponse getProfile();

    ApiResponse updateProfile(UpdateProfileRequest request);

    ApiResponse changePassword(ChangePasswordRequest request);

}