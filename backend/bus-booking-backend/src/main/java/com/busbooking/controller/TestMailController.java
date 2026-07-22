package com.busbooking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.busbooking.services.EmailService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class TestMailController {

    private final EmailService emailService;

    @PostMapping("/mail")
    public ResponseEntity<String> sendMail() {

        emailService.sendEmail(
                "2021bcs073@sggs.ac.in",    
                "TravelX Test Email",
                """
                Hello,

                Congratulations!

                Your Spring Boot Email Configuration is working successfully.

                TravelX Team
                """
        );

        return ResponseEntity.ok("Email Sent Successfully");
    }
}