package com.backend.serviceImpl;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.dto.CreatePaymentOrderRequest;
import com.backend.dto.CreatePaymentOrderResponse;
import com.backend.dto.VerifyPaymentRequest;
import com.backend.dto.VerifyPaymentResponse;
import com.backend.entity.PaymentOrder;
import com.backend.entity.PaymentOrderStatus;
import com.backend.repository.PaymentOrderRepository;
import com.backend.service.PaymentService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private final RazorpayClient razorpayClient;

    private final PaymentOrderRepository paymentOrderRepository;

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;

    @Override
    public CreatePaymentOrderResponse createOrder(
            CreatePaymentOrderRequest request) {

        System.out.println(
                "[PAYMENT] Creating payment order"
        );

        System.out.println(
                "[PAYMENT] Booking ID: "
                        + request.getBookingId()
        );

        System.out.println(
                "[PAYMENT] Amount: "
                        + request.getAmount()
        );

        if (request.getAmount() == null ||
                request.getAmount()
                        .compareTo(BigDecimal.ZERO) <= 0) {

            throw new IllegalArgumentException(
                    "Payment amount must be greater than zero."
            );
        }

        long amountInPaise =
                request.getAmount()
                        .multiply(BigDecimal.valueOf(100))
                        .longValueExact();

        try {

            JSONObject options =
                    new JSONObject();

            options.put(
                    "amount",
                    amountInPaise
            );

            options.put(
                    "currency",
                    "INR"
            );

            options.put(
                    "receipt",
                    "TRAVELX-" +
                            request.getBookingId()
            );

            options.put(
                    "payment_capture",
                    1
            );

            Order razorpayOrder =
                    razorpayClient.orders.create(
                            options
                    );

            String razorpayOrderId =
                    razorpayOrder.get("id");

            System.out.println(
                    "[PAYMENT] Razorpay Order ID: "
                            + razorpayOrderId
            );

            PaymentOrder paymentOrder =
                    new PaymentOrder();

            paymentOrder.setBookingId(
                    request.getBookingId()
            );

            paymentOrder.setRazorpayOrderId(
                    razorpayOrderId
            );

            paymentOrder.setAmount(
                    request.getAmount()
            );

            paymentOrder.setCurrency(
                    "INR"
            );

            paymentOrder.setStatus(
                    PaymentOrderStatus.CREATED
            );

            paymentOrder.setCreatedAt(
                    LocalDateTime.now()
            );

            paymentOrder.setUpdatedAt(
                    LocalDateTime.now()
            );

            paymentOrderRepository.save(
                    paymentOrder
            );

            System.out.println(
                    "[PAYMENT] Payment order saved."
            );

            return new CreatePaymentOrderResponse(
                    razorpayOrderId,
                    razorpayKeyId,
                    request.getAmount(),
                    "INR",
                    request.getBookingId()
            );

        } catch (Exception e) {

            System.err.println(
                    "[PAYMENT] Failed to create Razorpay order"
            );

            e.printStackTrace();

            throw new RuntimeException(
                    "Unable to create Razorpay order.",
                    e
            );
        }
    }

    @Override
    public VerifyPaymentResponse verifyPayment(
            VerifyPaymentRequest request) {

        System.out.println(
                "[PAYMENT] Starting payment verification"
        );

        System.out.println(
                "[PAYMENT] Booking ID: "
                        + request.getBookingId()
        );

        System.out.println(
                "[PAYMENT] Razorpay Order ID: "
                        + request.getRazorpayOrderId()
        );

        System.out.println(
                "[PAYMENT] Razorpay Payment ID: "
                        + request.getRazorpayPaymentId()
        );

        PaymentOrder paymentOrder =
                paymentOrderRepository
                        .findByRazorpayOrderId(
                                request.getRazorpayOrderId()
                        )
                        .orElseThrow(() ->
                                new IllegalArgumentException(
                                        "Payment order not found."
                                )
                        );

        if (!paymentOrder.getBookingId()
                .equals(request.getBookingId())) {

            throw new IllegalArgumentException(
                    "Booking ID does not match payment order."
            );
        }

        /*
         * Idempotency:
         *
         * If payment was already verified successfully,
         * do not process it again.
         */
        if (paymentOrder.getStatus()
                == PaymentOrderStatus.PAID) {

            System.out.println(
                    "[PAYMENT] Payment already marked PAID."
            );

            return new VerifyPaymentResponse(
                    true,
                    "Payment already verified.",
                    paymentOrder.getBookingId(),
                    request.getRazorpayPaymentId(),
                    paymentOrder.getRazorpayOrderId()
            );
        }

        String generatedSignature =
                generateSignature(
                        request.getRazorpayOrderId(),
                        request.getRazorpayPaymentId()
                );

        boolean signatureValid =
                MessageDigest.isEqual(
                        generatedSignature.getBytes(
                                StandardCharsets.UTF_8
                        ),
                        request.getRazorpaySignature()
                                .getBytes(
                                        StandardCharsets.UTF_8
                                )
                );

        if (!signatureValid) {

            System.err.println(
                    "[PAYMENT] INVALID RAZORPAY SIGNATURE"
            );

            throw new IllegalArgumentException(
                    "Payment signature verification failed."
            );
        }

        System.out.println(
                "[PAYMENT] Razorpay signature verified."
        );

        paymentOrder.setStatus(
                PaymentOrderStatus.PAID
        );

        paymentOrder.setUpdatedAt(
                LocalDateTime.now()
        );

        paymentOrderRepository.save(
                paymentOrder
        );

        System.out.println(
                "[PAYMENT] Payment marked PAID."
        );

        return new VerifyPaymentResponse(
                true,
                "Payment verified successfully.",
                paymentOrder.getBookingId(),
                request.getRazorpayPaymentId(),
                paymentOrder.getRazorpayOrderId()
        );
    }

    private String generateSignature(
            String razorpayOrderId,
            String razorpayPaymentId) {

        try {

            String payload =
                    razorpayOrderId
                            + "|"
                            + razorpayPaymentId;

            Mac mac =
                    Mac.getInstance(
                            "HmacSHA256"
                    );

            SecretKeySpec secretKey =
                    new SecretKeySpec(
                            razorpayKeySecret.getBytes(
                                    StandardCharsets.UTF_8
                            ),
                            "HmacSHA256"
                    );

            mac.init(secretKey);

            byte[] hash =
                    mac.doFinal(
                            payload.getBytes(
                                    StandardCharsets.UTF_8
                            )
                    );

            StringBuilder hex =
                    new StringBuilder();

            for (byte b : hash) {

                hex.append(
                        String.format(
                                "%02x",
                                b
                        )
                );
            }

            return hex.toString();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to generate payment signature.",
                    e
            );
        }
    }
}