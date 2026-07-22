package com.busbooking.servicesImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.entities.EmailOtp;
import com.busbooking.repository.EmailOtpRepository;
import com.busbooking.repository.UserRepository;
import com.busbooking.services.EmailService;
import com.busbooking.services.OtpService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {

    private final EmailOtpRepository otpRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;

    // =====================================================
    // Registration OTP
    // =====================================================

    @Override
    public ApiResponse sendRegistrationOtp(String email) {

        if (userRepository.existsByEmail(email)) {
            return new ApiResponse("Email already registered");
        }

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

        otpRepository.save(emailOtp);

        String subject = "TravelX Registration OTP";

        String body = """
                Welcome to TravelX

                Your Registration OTP is:

                %s

                This OTP is valid for 5 minutes.

                Do not share this OTP with anyone.

                TravelX Team
                """.formatted(otp);

        emailService.sendEmail(email, subject, body);

        return new ApiResponse("OTP Sent Successfully");
    }

    @Override
    public boolean verifyRegistrationOtp(
            String email,
            String otp) {

        Optional<EmailOtp> optionalOtp =
                otpRepository.findTopByEmailAndPurposeOrderByCreatedAtDesc(
                        email,
                        "REGISTER");

        if (optionalOtp.isEmpty()) {
            return false;
        }

        EmailOtp emailOtp = optionalOtp.get();

        if (emailOtp.getVerified()) {
            return false;
        }

        if (LocalDateTime.now().isAfter(
                emailOtp.getExpiryTime())) {
            return false;
        }

        if (!emailOtp.getOtpCode().equals(otp)) {

            emailOtp.setAttempts(
                    emailOtp.getAttempts() + 1);

            otpRepository.save(emailOtp);

            return false;
        }

        emailOtp.setVerified(true);

        otpRepository.save(emailOtp);

        return true;
    }

    @Override
    public boolean isRegistrationOtpVerified(
            String email) {

        return otpRepository
                .findTopByEmailAndPurposeAndVerifiedOrderByCreatedAtDesc(
                        email,
                        "REGISTER",
                        true)
                .isPresent();
    }

    // =====================================================
    // Forgot Password OTP
    // =====================================================

    @Override
    public ApiResponse sendForgotPasswordOtp(
            String email) {

        if (!userRepository.existsByEmail(email)) {
            return new ApiResponse("Email not registered");
        }

        String otp = String.valueOf(
                100000 + new Random().nextInt(900000));

        EmailOtp emailOtp = new EmailOtp();

        emailOtp.setEmail(email);
        emailOtp.setOtpCode(otp);
        emailOtp.setPurpose("FORGOT_PASSWORD");
        emailOtp.setVerified(false);
        emailOtp.setAttempts(0);
        emailOtp.setExpiryTime(
                LocalDateTime.now().plusMinutes(5));

        otpRepository.save(emailOtp);

        String subject = "TravelX Password Reset OTP";

        String body = """
                Hello,

                Your Password Reset OTP is:

                %s

                This OTP is valid for 5 minutes.

                Do not share this OTP.

                TravelX Team
                """.formatted(otp);

        emailService.sendEmail(email, subject, body);

        return new ApiResponse("OTP Sent Successfully");
    }

    @Override
    public boolean verifyForgotPasswordOtp(
            String email,
            String otp) {

        Optional<EmailOtp> optionalOtp =
                otpRepository.findTopByEmailAndPurposeOrderByCreatedAtDesc(
                        email,
                        "FORGOT_PASSWORD");

        if (optionalOtp.isEmpty()) {
            return false;
        }

        EmailOtp emailOtp = optionalOtp.get();

        if (emailOtp.getVerified()) {
            return false;
        }

        if (LocalDateTime.now().isAfter(
                emailOtp.getExpiryTime())) {
            return false;
        }

        if (!emailOtp.getOtpCode().equals(otp)) {

            emailOtp.setAttempts(
                    emailOtp.getAttempts() + 1);

            otpRepository.save(emailOtp);

            return false;
        }

        emailOtp.setVerified(true);

        otpRepository.save(emailOtp);

        return true;
    }

    @Override
    public boolean isForgotPasswordOtpVerified(
            String email) {

        return otpRepository
                .findTopByEmailAndPurposeAndVerifiedOrderByCreatedAtDesc(
                        email,
                        "FORGOT_PASSWORD",
                        true)
                .isPresent();
    }

}