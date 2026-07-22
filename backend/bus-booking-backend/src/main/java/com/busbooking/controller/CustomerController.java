package com.busbooking.controller;

import com.busbooking.dtos.CustomerProfileResponse;
import com.busbooking.services.CustomerService;

import lombok.RequiredArgsConstructor;

import jakarta.validation.Valid;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.UpdateProfileRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/profile")
    public ResponseEntity<CustomerProfileResponse> getProfile() {

        return ResponseEntity.ok(
                customerService.getProfile());

    }
    
    @PutMapping("/profile")
    public ResponseEntity<ApiResponse> updateProfile(
            @RequestBody @Valid UpdateProfileRequest request) {

        return ResponseEntity.ok(
                customerService.updateProfile(request));
    }

}