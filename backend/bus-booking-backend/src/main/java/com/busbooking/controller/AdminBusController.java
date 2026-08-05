package com.busbooking.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.busbooking.dtos.AdminBusDetailsResponse;
import com.busbooking.dtos.AdminBusResponse;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.services.AdminBusService;
import com.busbooking.dtos.RejectBusRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/buses")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AdminBusController {

    private final AdminBusService adminBusService;

    @GetMapping
    public ResponseEntity<List<AdminBusResponse>>
    getAllBuses() {

        return ResponseEntity.ok(
                adminBusService.getAllBuses());

    }

    @GetMapping("/{busId}")
    public ResponseEntity<AdminBusDetailsResponse>
    getBusDetails(
            @PathVariable Long busId) {

        return ResponseEntity.ok(
                adminBusService.getBusDetails(
                        busId));

    }

    @PutMapping("/{busId}/approve")
    public ResponseEntity<ApiResponse>
    approveBus(
            @PathVariable Long busId) {

        return ResponseEntity.ok(
                adminBusService.approveBus(
                        busId));

    }

    @PutMapping("/{busId}/reject")
    public ResponseEntity<ApiResponse>
    rejectBus(
            @PathVariable Long busId,
            @Valid
            @RequestBody
            RejectBusRequest request) {

        return ResponseEntity.ok(
                adminBusService.rejectBus(
                        busId,
                        request));

    }

}