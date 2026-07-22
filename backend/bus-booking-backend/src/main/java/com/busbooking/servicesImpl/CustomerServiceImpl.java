package com.busbooking.servicesImpl;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.ChangePasswordRequest;
import com.busbooking.dtos.CustomerProfileResponse;
import com.busbooking.dtos.UpdateProfileRequest;
import com.busbooking.entities.User;
import com.busbooking.repository.UserRepository;
import com.busbooking.services.CustomerService;

import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    @Override
    public CustomerProfileResponse getProfile() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return modelMapper.map(user,
                CustomerProfileResponse.class);
    }

    @Override
    public ApiResponse updateProfile(UpdateProfileRequest request) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setGender(request.getGender());

        userRepository.save(user);

        return new ApiResponse("Profile Updated Successfully");
    }

    @Override
    public ApiResponse changePassword(ChangePasswordRequest request) {
        return null;
    }
}