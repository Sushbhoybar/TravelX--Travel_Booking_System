package com.busbooking.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;

import com.busbooking.dtos.AddBusRequest;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.BusDetailsResponse;
import com.busbooking.dtos.BusResponse;
import com.busbooking.dtos.UpdateBusRequest;
import com.busbooking.services.BusService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/agent/buses")
@RequiredArgsConstructor
@Validated
public class AgentBusController {

    private final BusService busService;

    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ApiResponse> addBus(

    		@Valid
    		@ModelAttribute AddBusRequest request,

            Authentication authentication

    ) {
    	
    	System.out.println("========== CONTROLLER REACHED ==========");

        System.out.println("Authentication = " + authentication);

        String email = authentication.getName();

        ApiResponse response =
                busService.addBus(request, email);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }

    @GetMapping
    public ResponseEntity<List<BusResponse>> getMyBuses(
            Principal principal) {

        return ResponseEntity.ok(
                busService.getMyBuses(
                        principal.getName()));
    }

    @GetMapping("/{busId}")
    public ResponseEntity<BusDetailsResponse> getBusDetails(
            @PathVariable Long busId) {

        return ResponseEntity.ok(
                busService.getBusDetails(busId));
    }

    @PutMapping(
            value="/{busId}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ApiResponse> updateBus(

            @PathVariable Long busId,
            
            @Valid
            @ModelAttribute UpdateBusRequest request

    ){

        return ResponseEntity.ok(
                busService.updateBus(
                        busId,
                        request));
    }

    @DeleteMapping("/{busId}")
    public ResponseEntity<ApiResponse> deleteBus(
            @PathVariable Long busId) {

        return ResponseEntity.ok(
                busService.deleteBus(busId));
    }

}