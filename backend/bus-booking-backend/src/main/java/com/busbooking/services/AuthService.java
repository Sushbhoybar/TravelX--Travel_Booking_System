package com.busbooking.services;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.LoginRequest;
import com.busbooking.dtos.LoginResponse;
import com.busbooking.dtos.RegisterRequest;

public interface AuthService {

    ApiResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}