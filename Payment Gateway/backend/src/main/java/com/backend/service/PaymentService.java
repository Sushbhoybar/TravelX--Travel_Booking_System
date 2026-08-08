package com.backend.service;

import com.backend.dto.CreatePaymentOrderRequest;
import com.backend.dto.CreatePaymentOrderResponse;
import com.backend.dto.VerifyPaymentRequest;
import com.backend.dto.VerifyPaymentResponse;

public interface PaymentService {

    CreatePaymentOrderResponse createOrder(
            CreatePaymentOrderRequest request
    );

    VerifyPaymentResponse verifyPayment(
            VerifyPaymentRequest request
    );
}