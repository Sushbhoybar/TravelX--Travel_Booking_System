package com.busbooking.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.busbooking.dtos.AddBusRequest;
import com.busbooking.dtos.AgentBusDetailsResponse;
import com.busbooking.dtos.AgentBusResponse;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.BusDetailsResponse;
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

        String email = authentication.getName();

        ApiResponse response =
                busService.addBus(
                        request,
                        email);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }

    @GetMapping
    public ResponseEntity<List<AgentBusResponse>> getMyBuses(
            Principal principal) {

        return ResponseEntity.ok(
                busService.getMyBuses(
                        principal.getName()));

    }

    @GetMapping("/{busId}")
    public ResponseEntity<BusDetailsResponse> getBusDetails(

            @PathVariable Long busId,

            Principal principal

    ) {

        return ResponseEntity.ok(

                busService.getBusDetails(
                        busId,
                        principal.getName())

        );

    }

    @GetMapping("/{busId}/edit")
    public ResponseEntity<AgentBusDetailsResponse> getBus(

            @PathVariable Long busId,

            Principal principal

    ) {

        return ResponseEntity.ok(

                busService.getBus(
                        busId,
                        principal.getName())

        );

    }

    @PutMapping(
            value = "/{busId}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ApiResponse> updateBus(

            @PathVariable Long busId,

            @Valid
            @ModelAttribute UpdateBusRequest request,

            Principal principal

    ) {

        return ResponseEntity.ok(

                busService.updateBus(
                        busId,
                        request,
                        principal.getName())

        );

    }

    @DeleteMapping("/{busId}")
    public ResponseEntity<ApiResponse> deleteBus(

            @PathVariable Long busId,

            Principal principal

    ) {

        return ResponseEntity.ok(

                busService.deleteBus(
                        busId,
                        principal.getName())

        );

    }

}