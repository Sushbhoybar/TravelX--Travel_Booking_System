package com.busbooking.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.busbooking.dtos.AgentDetailsResponse;
import com.busbooking.dtos.AgentResponse;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.services.AdminAgentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin/agents")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AdminAgentController {

    private final AdminAgentService adminAgentService;

    // ==========================================
    // Get All Agents
    // ==========================================

    @GetMapping
    public ResponseEntity<List<AgentResponse>> getAllAgents() {

        return ResponseEntity.ok(
                adminAgentService.getAllAgents());

    }

    // ==========================================
    // Get Agent Details
    // ==========================================

    @GetMapping("/{userId}")
    public ResponseEntity<AgentDetailsResponse> getAgentDetails(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                adminAgentService.getAgentDetails(userId));

    }

    // ==========================================
    // Approve Agent
    // ==========================================

    @PutMapping("/{userId}/approve")
    public ResponseEntity<ApiResponse> approveAgent(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                adminAgentService.approveAgent(userId));

    }

    // ==========================================
    // Reject Agent
    // ==========================================

    @PutMapping("/{userId}/reject")
    public ResponseEntity<ApiResponse> rejectAgent(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                adminAgentService.rejectAgent(userId));

    }

    // ==========================================
    // Suspend Agent
    // ==========================================

    @PutMapping("/{userId}/suspend")
    public ResponseEntity<ApiResponse> suspendAgent(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                adminAgentService.suspendAgent(userId));

    }

    // ==========================================
    // Activate Agent
    // ==========================================

    @PutMapping("/{userId}/activate")
    public ResponseEntity<ApiResponse> activateAgent(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                adminAgentService.activateAgent(userId));

    }

}