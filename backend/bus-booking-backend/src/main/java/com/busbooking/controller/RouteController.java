//package com.busbooking.controller;
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.busbooking.dtos.ApiResponse;
//import com.busbooking.dtos.CreateRouteRequest;
//import com.busbooking.dtos.RouteResponse;
//import com.busbooking.services.RouteService;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/api/routes")
//@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:5173")
//public class RouteController {
//
//    private final RouteService routeService;
//
//    @PostMapping
//    public ResponseEntity<ApiResponse> addRoute(
//            @RequestBody
//            @Valid
//            CreateRouteRequest request) {
//
//        return ResponseEntity
//
//                .status(HttpStatus.CREATED)
//
//                .body(routeService.addRoute(request));
//
//    }
//
//    @GetMapping
//    public ResponseEntity<List<RouteResponse>> getAllRoutes() {
//
//        return ResponseEntity.ok(
//
//                routeService.getAllRoutes());
//
//    }
//
//    @GetMapping("/{routeId}")
//    public ResponseEntity<RouteResponse> getRouteById(
//
//            @PathVariable Long routeId) {
//
//        return ResponseEntity.ok(
//
//                routeService.getRouteById(routeId));
//
//    }
//
//    @DeleteMapping("/{routeId}")
//    public ResponseEntity<ApiResponse> deleteRoute(
//
//            @PathVariable Long routeId) {
//
//        return ResponseEntity.ok(
//
//                routeService.deleteRoute(routeId));
//
//    }
//
//}