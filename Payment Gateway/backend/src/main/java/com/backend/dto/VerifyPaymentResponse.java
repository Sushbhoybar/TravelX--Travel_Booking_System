package com.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VerifyPaymentResponse {

    private boolean success;

    private String message;

    private Long bookingId;

    private String razorpayPaymentId;

    private String razorpayOrderId;
}