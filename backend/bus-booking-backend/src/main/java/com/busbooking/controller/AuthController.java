package com.busbooking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.LoginRequest;
import com.busbooking.dtos.LoginResponse;
import com.busbooking.dtos.RegisterRequest;
import com.busbooking.dtos.SendOtpRequest;
import com.busbooking.dtos.VerifyOtpRequest;
import com.busbooking.services.AuthService;
import com.busbooking.services.OtpService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Validated
//@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;
    private final OtpService otpService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }
    
    @PostMapping("/send-registration-otp")
    public ResponseEntity<ApiResponse> sendRegistrationOtp(
            @Valid @RequestBody SendOtpRequest request) {

        return ResponseEntity.ok(
                otpService.sendRegistrationOtp(request.getEmail()));
    }
    
    @PostMapping("/verify-registration-otp")
    public ResponseEntity<ApiResponse> verifyRegistrationOtp(
            @Valid @RequestBody VerifyOtpRequest request) {

        return ResponseEntity.ok(
                otpService.verifyRegistrationOtp(
                        request.getEmail(),
                        request.getOtp()));
    }

}