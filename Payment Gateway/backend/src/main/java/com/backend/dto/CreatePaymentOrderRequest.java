package com.backend.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePaymentOrderRequest {

    @NotNull
    private Long bookingId;

    @NotNull
    private BigDecimal amount;
}