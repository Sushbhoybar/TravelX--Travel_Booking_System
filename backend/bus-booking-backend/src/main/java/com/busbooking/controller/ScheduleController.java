//package com.busbooking.controller;
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.busbooking.dtos.ApiResponse;
//import com.busbooking.dtos.CreateScheduleRequest;
//import com.busbooking.dtos.ScheduleResponse;
//import com.busbooking.services.ScheduleService;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/api/schedules")
//@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:5173")
//public class ScheduleController {
//
//    private final ScheduleService scheduleService;
//
//    @PostMapping
//    public ResponseEntity<ApiResponse> addSchedule(
//            @Valid @RequestBody CreateScheduleRequest request) {
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(scheduleService.addSchedule(request));
//    }
//
//    @GetMapping
//    public ResponseEntity<List<ScheduleResponse>> getAllSchedules() {
//
//        return ResponseEntity.ok(
//                scheduleService.getAllSchedules());
//    }
//
//    @GetMapping("/{scheduleId}")
//    public ResponseEntity<ScheduleResponse> getScheduleById(
//            @PathVariable Long scheduleId) {
//
//        return ResponseEntity.ok(
//                scheduleService.getScheduleById(scheduleId));
//    }
//
//    @DeleteMapping("/{scheduleId}")
//    public ResponseEntity<ApiResponse> deleteSchedule(
//            @PathVariable Long scheduleId) {
//
//        return ResponseEntity.ok(
//                scheduleService.deleteSchedule(scheduleId));
//    }
//
//}