package com.busbooking.services;

import com.busbooking.dtos.ApiResponse;

public interface OtpService {

	ApiResponse sendRegistrationOtp(String email);

	ApiResponse verifyRegistrationOtp(String email, String otp);

	boolean isRegistrationOtpVerified(String email);
	
	ApiResponse sendForgotPasswordOtp(String email);

	boolean verifyForgotPasswordOtp(
	        String email,
	        String otp);

	boolean isForgotPasswordOtpVerified(
	        String email);

}