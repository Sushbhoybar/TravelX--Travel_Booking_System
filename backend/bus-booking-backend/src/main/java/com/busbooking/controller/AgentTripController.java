//package com.busbooking.controller;
//
//import java.security.Principal;
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import com.busbooking.dtos.ApiResponse;
//import com.busbooking.dtos.TripDetailsResponse;
//import com.busbooking.dtos.TripRequest;
//import com.busbooking.dtos.TripResponse;
//import com.busbooking.services.TripService;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/api/agent/trips")
//@RequiredArgsConstructor
//@Validated
//public class AgentTripController {
//
//    private final TripService tripService;
//
//    @PostMapping
//    public ResponseEntity<ApiResponse> createTrip(
//
//            @Valid
//            @RequestBody
//            TripRequest request,
//
//            Principal principal) {
//
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(
//                        tripService.createTrip(
//                                request,
//                                principal.getName()));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<TripResponse>> getMyTrips(
//            Principal principal) {
//
//        return ResponseEntity.ok(
//
//                tripService.getMyTrips(
//                        principal.getName()));
//
//    }
//
//    @GetMapping("/{tripId}")
//    public ResponseEntity<TripDetailsResponse> getTrip(
//            @PathVariable Long tripId) {
//
//        return ResponseEntity.ok(
//
//                tripService.getTrip(tripId));
//
//    }
//
//    @PutMapping("/{tripId}")
//    public ResponseEntity<ApiResponse> updateTrip(
//
//            @PathVariable Long tripId,
//
//            @Valid
//            @RequestBody
//            TripRequest request) {
//
//        return ResponseEntity.ok(
//
//                tripService.updateTrip(
//                        tripId,
//                        request));
//
//    }
//
//    @DeleteMapping("/{tripId}")
//    public ResponseEntity<ApiResponse> deleteTrip(
//            @PathVariable Long tripId) {
//
//        return ResponseEntity.ok(
//
//                tripService.deleteTrip(
//                        tripId));
//
//    }
//
//}