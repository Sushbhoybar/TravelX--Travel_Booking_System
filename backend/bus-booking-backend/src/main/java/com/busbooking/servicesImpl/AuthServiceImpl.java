package com.busbooking.servicesImpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busbooking.custom_exception.DuplicateResourceException;
import com.busbooking.custom_exception.InvalidCredentialsException;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.LoginRequest;
import com.busbooking.dtos.LoginResponse;
import com.busbooking.dtos.RegisterRequest;
import com.busbooking.dtos.ResetPasswordRequest;
import com.busbooking.entities.Customer;
import com.busbooking.entities.User;
import com.busbooking.entities.UserRole;
import com.busbooking.repository.CustomerRepository;
import com.busbooking.repository.EmailOtpRepository;
import com.busbooking.repository.UserRepository;
import com.busbooking.security.JwtUtil;
import com.busbooking.services.AuthService;
import com.busbooking.services.OtpService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final EmailOtpRepository emailOtpRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final OtpService otpService;

    // ==========================================
    // Register
    // ==========================================

    @Override
    public ApiResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new DuplicateResourceException("Phone number already exists");
        }

        if (!otpService.isRegistrationOtpVerified(request.getEmail())) {
            throw new InvalidCredentialsException(
                    "Please verify your email first.");
        }

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setLastName(request.getLastName());

        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        user.setGender(request.getGender());

        user.setPassword(
                passwordEncoder.encode(request.getPassword()));

        user.setRole(UserRole.CUSTOMER);

        user.setIsActive(true);

        User savedUser = userRepository.save(user);

        Customer customer = new Customer();

        customer.setUser(savedUser);

        customerRepository.save(customer);

        emailOtpRepository.deleteByEmailAndPurpose(
                request.getEmail(),
                "REGISTER");

        return new ApiResponse(
                "Customer Registered Successfully");
    }

    // ==========================================
    // Login
    // ==========================================

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException(
                                "Invalid Email or Password"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new InvalidCredentialsException(
                    "Invalid Email or Password");
        }

        String fullName =
                user.getFirstName() + " " +
                (user.getMiddleName() == null
                        ? ""
                        : user.getMiddleName() + " ")
                + user.getLastName();

        String token =
                jwtUtil.generateToken(user.getEmail());

        return new LoginResponse(
                user.getUserId(),
                fullName.trim(),
                user.getEmail(),
                user.getRole().name(),
                token);
    }

    // ==========================================
    // Reset Password
    // ==========================================

    @Override
    public ApiResponse resetPassword(
            ResetPasswordRequest request) {

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new InvalidCredentialsException(
                                "Email not registered"));

        if (!otpService.isForgotPasswordOtpVerified(
                request.getEmail())) {

            throw new InvalidCredentialsException(
                    "Please verify OTP first.");
        }

        user.setPassword(
                passwordEncoder.encode(
                        request.getNewPassword()));

        userRepository.save(user);

        emailOtpRepository.deleteByEmailAndPurpose(
                request.getEmail(),
                "FORGOT_PASSWORD");

        return new ApiResponse(
                "Password Reset Successfully");
    }

}