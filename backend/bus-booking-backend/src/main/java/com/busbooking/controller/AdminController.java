//package com.busbooking.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.busbooking.dtos.AdminLoginRequest;
//import com.busbooking.dtos.AdminLoginResponse;
//import com.busbooking.dtos.ApiResponse;
//import com.busbooking.dtos.BusDetailsResponse;
//import com.busbooking.services.AdminService;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import java.util.List;
//import com.busbooking.dtos.UserResponse;
//import com.busbooking.dtos.BusResponse;
//
//import com.busbooking.dtos.FeedbackResponse;
//
//
//@RestController
//@RequestMapping("/api/admin")
//@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:5173")
//public class AdminController {
//
//    private final AdminService adminService;
//
//    @PostMapping("/login")
//    public ResponseEntity<AdminLoginResponse> login(
//            @Valid @RequestBody AdminLoginRequest request){
//
//        return ResponseEntity.ok(adminService.login(request));
//    }
//    
//    @GetMapping("/users")
//    public ResponseEntity<List<UserResponse>> getAllUsers() {
//        return ResponseEntity.ok(adminService.getAllUsers());
//    }
//    
//    @PutMapping("/users/{id}/block")
//    public ResponseEntity<ApiResponse> blockUser(@PathVariable Long id) {
//
//        return ResponseEntity.ok(adminService.blockUser(id));
//    }
//
//    @PutMapping("/users/{id}/unblock")
//    public ResponseEntity<ApiResponse> unblockUser(@PathVariable Long id) {
//
//        return ResponseEntity.ok(adminService.unblockUser(id));
//    }
//    
//    @DeleteMapping("/users/{id}")
//    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
//
//        return ResponseEntity.ok(adminService.deleteUser(id));
//
//    }
//    
//    @GetMapping("/buses")
//    public ResponseEntity<List<BusResponse>> getAllBuses() {
//
//        return ResponseEntity.ok(adminService.getAllBuses());
//
//    }
//    
//    
//    @GetMapping("/buses/{id}")
//    public ResponseEntity<BusDetailsResponse> getBus(@PathVariable Long id) {
//
//        return ResponseEntity.ok(adminService.getBusById(id));
//    }
//
//    @PutMapping("/buses/{id}/approve")
//    public ResponseEntity<ApiResponse> approveBus(@PathVariable Long id) {
//
//        return ResponseEntity.ok(adminService.approveBus(id));
//    }
//
//    @PutMapping("/buses/{id}/reject")
//    public ResponseEntity<ApiResponse> rejectBus(@PathVariable Long id) {
//
//        return ResponseEntity.ok(adminService.rejectBus(id));
//    }
//    
//    @GetMapping("/feedback")
//    public ResponseEntity<List<FeedbackResponse>> getAllFeedback() {
//
//        return ResponseEntity.ok(adminService.getAllFeedback());
//
//    }
//    
//}