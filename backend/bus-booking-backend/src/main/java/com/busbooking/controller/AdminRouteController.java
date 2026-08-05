package com.busbooking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.RouteRequest;
import com.busbooking.dtos.RouteResponse;
import com.busbooking.services.RouteService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/routes")
@RequiredArgsConstructor
@Validated
public class AdminRouteController {

    private final RouteService routeService;

    @PostMapping
    public ResponseEntity<ApiResponse> addRoute(

            @Valid
            @RequestBody
            RouteRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(routeService.addRoute(request));
    }

    @GetMapping
    public ResponseEntity<List<RouteResponse>> getAllRoutes() {

        return ResponseEntity.ok(
                routeService.getAllRoutes());
    }

    @GetMapping("/{routeId}")
    public ResponseEntity<RouteResponse> getRoute(

            @PathVariable
            Long routeId) {

        return ResponseEntity.ok(
                routeService.getRoute(routeId));
    }

    @PutMapping("/{routeId}")
    public ResponseEntity<ApiResponse> updateRoute(

            @PathVariable
            Long routeId,

            @Valid
            @RequestBody
            RouteRequest request) {

        return ResponseEntity.ok(
                routeService.updateRoute(
                        routeId,
                        request));
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<ApiResponse> deleteRoute(

            @PathVariable
            Long routeId) {

        return ResponseEntity.ok(
                routeService.deleteRoute(routeId));
    }

}