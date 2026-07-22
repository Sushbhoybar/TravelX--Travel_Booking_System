package com.busbooking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.LoginRequest;
import com.busbooking.dtos.LoginResponse;
import com.busbooking.dtos.RegisterRequest;
import com.busbooking.dtos.ResetPasswordRequest;
import com.busbooking.dtos.SendOtpRequest;
import com.busbooking.dtos.VerifyOtpRequest;
import com.busbooking.services.AuthService;
import com.busbooking.services.OtpService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthService authService;
    private final OtpService otpService;

    // ===============================
    // REGISTER
    // ===============================

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authService.register(request));
    }

    // ===============================
    // LOGIN
    // ===============================

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(
                authService.login(request));
    }

    // ===============================
    // REGISTRATION OTP
    // ===============================

    @PostMapping("/send-registration-otp")
    public ResponseEntity<ApiResponse> sendRegistrationOtp(
            @Valid @RequestBody SendOtpRequest request) {

        otpService.sendRegistrationOtp(
                request.getEmail());

        return ResponseEntity.ok(
                new ApiResponse("OTP Sent Successfully"));
    }

    @PostMapping("/verify-registration-otp")
    public ResponseEntity<ApiResponse> verifyRegistrationOtp(
            @Valid @RequestBody VerifyOtpRequest request) {

        boolean verified =
                otpService.verifyRegistrationOtp(
                        request.getEmail(),
                        request.getOtp());

        if (!verified) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse(
                            "Invalid or Expired OTP"));
        }

        return ResponseEntity.ok(
                new ApiResponse(
                        "OTP Verified Successfully"));
    }

    // ===============================
    // FORGOT PASSWORD OTP
    // ===============================

    @PostMapping("/send-forgot-password-otp")
    public ResponseEntity<ApiResponse> sendForgotPasswordOtp(
            @Valid @RequestBody SendOtpRequest request) {

        otpService.sendForgotPasswordOtp(
                request.getEmail());

        return ResponseEntity.ok(
                new ApiResponse(
                        "OTP Sent Successfully"));
    }

    @PostMapping("/verify-forgot-password-otp")
    public ResponseEntity<ApiResponse> verifyForgotPasswordOtp(
            @Valid @RequestBody VerifyOtpRequest request) {

        boolean verified =
                otpService.verifyForgotPasswordOtp(
                        request.getEmail(),
                        request.getOtp());

        if (!verified) {

            return ResponseEntity.badRequest()
                    .body(new ApiResponse(
                            "Invalid or Expired OTP"));
        }

        return ResponseEntity.ok(
                new ApiResponse(
                        "OTP Verified Successfully"));
    }

    // ===============================
    // RESET PASSWORD
    // ===============================

    @PostMapping("/reset-password")
    public ResponseEntity<ApiResponse> resetPassword(
            @Valid @RequestBody ResetPasswordRequest request) {

        return ResponseEntity.ok(
                authService.resetPassword(request));
    }

}