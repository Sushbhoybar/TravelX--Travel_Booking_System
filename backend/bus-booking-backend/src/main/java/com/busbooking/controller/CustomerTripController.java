package com.busbooking.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.busbooking.dtos.CustomerTripDetailsResponse;
import com.busbooking.dtos.CustomerTripResponse;
import com.busbooking.dtos.SearchTripRequest;
import com.busbooking.dtos.TripSeatLayoutResponse;
import com.busbooking.services.CustomerTripService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer/trips")
@RequiredArgsConstructor
@Validated
public class CustomerTripController {

    private final CustomerTripService customerTripService;

    // =====================================================
    // Search Trips
    // =====================================================

    @PostMapping("/search")
    public ResponseEntity<List<CustomerTripResponse>> searchTrips(
            @Valid @RequestBody SearchTripRequest request) {

        return ResponseEntity.ok(
                customerTripService.searchTrips(request));
    }

    // =====================================================
    // Trip Details
    // =====================================================

    @GetMapping("/{tripId}")
    public ResponseEntity<CustomerTripDetailsResponse> getTripDetails(
            @PathVariable Long tripId) {

        return ResponseEntity.ok(
                customerTripService.getTripDetails(tripId));
    }
    
    
    @GetMapping("/{tripId}/seat-layout")
    public ResponseEntity<TripSeatLayoutResponse> getSeatLayout(
            @PathVariable Long tripId) {

        return ResponseEntity.ok(
                customerTripService.getTripSeatLayout(tripId));

    }

}