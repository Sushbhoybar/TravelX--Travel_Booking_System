package com.busbooking.servicesImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.busbooking.custom_exception.InvalidCredentialsException;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.entities.EmailOtp;
import com.busbooking.repository.EmailOtpRepository;
import com.busbooking.services.EmailService;
import com.busbooking.services.OtpService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {

    private final EmailOtpRepository emailOtpRepository;
    private final EmailService emailService;

    @Override
    public ApiResponse sendRegistrationOtp(String email) {

        String otp = String.valueOf(
                100000 + new Random().nextInt(900000));

        EmailOtp emailOtp = new EmailOtp();

        emailOtp.setEmail(email);
        emailOtp.setOtpCode(otp);
        emailOtp.setPurpose("REGISTER");
        emailOtp.setVerified(false);
        emailOtp.setAttempts(0);
        emailOtp.setExpiryTime(
                LocalDateTime.now().plusMinutes(5));

        emailOtpRepository.save(emailOtp);

        String subject = "TravelX Registration OTP";

        String body = """
                Welcome to TravelX

                Your OTP is:

                %s

                This OTP is valid for 5 minutes.

                Do not share this OTP with anyone.

                TravelX Team
                """.formatted(otp);

        emailService.sendEmail(email, subject, body);

        return new ApiResponse("OTP Sent Successfully");
    }

    @Override
    public ApiResponse verifyRegistrationOtp(
            String email,
            String otp) {

        Optional<EmailOtp> optionalOtp =
                emailOtpRepository.findTopByEmailAndPurposeOrderByCreatedAtDesc(
                        email,
                        "REGISTER");

        if (optionalOtp.isEmpty()) {
            throw new InvalidCredentialsException("OTP not found");
        }

        EmailOtp emailOtp = optionalOtp.get();

        if (Boolean.TRUE.equals(emailOtp.getVerified())) {
            throw new InvalidCredentialsException("OTP already verified");
        }

        if (LocalDateTime.now().isAfter(emailOtp.getExpiryTime())) {
            throw new InvalidCredentialsException("OTP expired");
        }

        if (!emailOtp.getOtpCode().equals(otp)) {

            emailOtp.setAttempts(emailOtp.getAttempts() + 1);
            emailOtpRepository.save(emailOtp);

            throw new InvalidCredentialsException("Invalid OTP");
        }

        emailOtp.setVerified(true);
        emailOtpRepository.save(emailOtp);

        return new ApiResponse("OTP Verified Successfully");
    }

    @Override
    public boolean isRegistrationOtpVerified(String email) {

        return emailOtpRepository
                .findTopByEmailAndPurposeAndVerifiedOrderByCreatedAtDesc(
                        email,
                        "REGISTER",
                        true)
                .isPresent();
    }

	@Override
	public ApiResponse sendForgotPasswordOtp(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyForgotPasswordOtp(String email, String otp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isForgotPasswordOtpVerified(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}