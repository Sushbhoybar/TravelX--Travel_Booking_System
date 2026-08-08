package com.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.backend.dto.CreatePaymentOrderRequest;
import com.backend.dto.CreatePaymentOrderResponse;
import com.backend.dto.VerifyPaymentRequest;
import com.backend.dto.VerifyPaymentResponse;
import com.backend.service.PaymentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@Validated
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create-order")
    public ResponseEntity<CreatePaymentOrderResponse> createOrder(
            @Valid @RequestBody CreatePaymentOrderRequest request) {

        return ResponseEntity.ok(
                paymentService.createOrder(request)
        );
    }

    @PostMapping("/verify")
    public ResponseEntity<VerifyPaymentResponse> verifyPayment(
            @Valid @RequestBody VerifyPaymentRequest request) {

        return ResponseEntity.ok(
                paymentService.verifyPayment(request)
        );
    }
}