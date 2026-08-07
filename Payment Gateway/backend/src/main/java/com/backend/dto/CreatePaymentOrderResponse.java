package com.backend.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreatePaymentOrderResponse {

    private String razorpayOrderId;

    private String keyId;

    private BigDecimal amount;

    private String currency;

    private Long bookingId;
}