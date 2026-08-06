package com.busbooking.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.CreateTripRequest;
import com.busbooking.dtos.RouteResponse;
import com.busbooking.dtos.AgentBusResponse;
import com.busbooking.dtos.TripDetailsResponse;
import com.busbooking.dtos.TripResponse;
import com.busbooking.services.TripService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/agent/trips")
@RequiredArgsConstructor
public class AgentTripController {

    private final TripService tripService;

    // =========================================================
    // CREATE TRIP
    // =========================================================

    @PostMapping
    public ResponseEntity<ApiResponse> createTrip(
            @Valid @RequestBody CreateTripRequest request,
            Principal principal) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        tripService.createTrip(
                                request,
                                principal.getName()));
    }

    // =========================================================
    // GET MY TRIPS
    // =========================================================

    @GetMapping
    public ResponseEntity<List<TripResponse>> getMyTrips(
            Principal principal) {

        return ResponseEntity.ok(
                tripService.getMyTrips(
                        principal.getName()));
    }

    // =========================================================
    // GET TRIP DETAILS
    // =========================================================

    @GetMapping("/{tripId}")
    public ResponseEntity<TripDetailsResponse> getTripDetails(
            @PathVariable Long tripId,
            Principal principal) {

        return ResponseEntity.ok(
                tripService.getTripDetails(
                        tripId,
                        principal.getName()));
    }

    // =========================================================
    // CANCEL TRIP
    // =========================================================

    @PutMapping("/{tripId}/cancel")
    public ResponseEntity<ApiResponse> cancelTrip(
            @PathVariable Long tripId,
            Principal principal) {

        return ResponseEntity.ok(
                tripService.cancelTrip(
                        tripId,
                        principal.getName()));
    }
    
    
    @GetMapping("/buses")
    public ResponseEntity<List<AgentBusResponse>> getApprovedBuses(
            Principal principal) {

        return ResponseEntity.ok(
                tripService.getApprovedBuses(
                        principal.getName()));
    }

    @GetMapping("/routes")
    public ResponseEntity<List<RouteResponse>> getRoutes() {

        return ResponseEntity.ok(
                tripService.getActiveRoutes());
    }

}