package com.busbooking.services;

import com.busbooking.dtos.ApiResponse;

public interface OtpService {

    // ==========================
    // Registration OTP
    // ==========================

    ApiResponse sendRegistrationOtp(String email);

    boolean verifyRegistrationOtp(
            String email,
            String otp);

    boolean isRegistrationOtpVerified(
            String email);


    // ==========================
    // Forgot Password OTP
    // ==========================

    ApiResponse sendForgotPasswordOtp(
            String email);

    boolean verifyForgotPasswordOtp(
            String email,
            String otp);

    boolean isForgotPasswordOtpVerified(
            String email);

}