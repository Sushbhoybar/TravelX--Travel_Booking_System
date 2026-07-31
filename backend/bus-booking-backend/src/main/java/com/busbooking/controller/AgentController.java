package com.busbooking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.busbooking.dtos.AgentRegisterRequest;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.services.AgentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/agent")
@RequiredArgsConstructor
@Validated
public class AgentController {

    private final AgentService agentService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerAgent(
            @Valid @RequestBody AgentRegisterRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(agentService.registerAgent(request));
    }

}