package com.busbooking.servicesImpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busbooking.custom_exception.DuplicateResourceException;
import com.busbooking.custom_exception.InvalidCredentialsException;
import com.busbooking.dtos.AgentRegisterRequest;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.entities.Agent;
import com.busbooking.entities.ApprovalStatus;
import com.busbooking.entities.User;
import com.busbooking.entities.UserRole;
import com.busbooking.repository.AgentRepository;
import com.busbooking.repository.EmailOtpRepository;
import com.busbooking.repository.UserRepository;
import com.busbooking.services.AgentService;
import com.busbooking.services.OtpService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AgentServiceImpl implements AgentService {

    private final UserRepository userRepository;

    private final AgentRepository agentRepository;

    private final EmailOtpRepository emailOtpRepository;

    private final PasswordEncoder passwordEncoder;

    private final OtpService otpService;

    @Override
    public ApiResponse registerAgent(
            AgentRegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException(
                    "Email already exists");
        }

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new DuplicateResourceException(
                    "Phone number already exists");
        }

        if (agentRepository.existsByAgencyName(
                request.getAgencyName())) {

            throw new DuplicateResourceException(
                    "Agency already exists");
        }

        if (agentRepository.existsByGstNumber(
                request.getGstNumber())) {

            throw new DuplicateResourceException(
                    "GST Number already exists");
        }

        if (agentRepository.existsByPanNumber(
                request.getPanNumber())) {

            throw new DuplicateResourceException(
                    "PAN Number already exists");
        }

        if (agentRepository.existsByBusinessLicense(
                request.getBusinessLicense())) {

            throw new DuplicateResourceException(
                    "Business License already exists");
        }

        if (!otpService.isRegistrationOtpVerified(
                request.getEmail())) {

            throw new InvalidCredentialsException(
                    "Please verify your email first.");
        }

        User user = new User();

        user.setFirstName(request.getFirstName());

        user.setMiddleName(request.getMiddleName());

        user.setLastName(request.getLastName());

        user.setEmail(request.getEmail());

        user.setPhone(request.getPhone());

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()));

        user.setGender(request.getGender());

        user.setRole(UserRole.AGENT);

        user.setIsActive(true);

        User savedUser =
                userRepository.save(user);

        Agent agent = new Agent();

        agent.setUser(savedUser);

        agent.setAgencyName(
                request.getAgencyName());

        agent.setGstNumber(
                request.getGstNumber());

        agent.setPanNumber(
                request.getPanNumber());

        agent.setBusinessLicense(
                request.getBusinessLicense());

        agent.setBankAccountNumber(
                request.getBankAccountNumber());

        agent.setIfscCode(
                request.getIfscCode());

        agent.setAccountHolderName(
                request.getAccountHolderName());

        agent.setAddress(
                request.getAddress());

        agent.setCity(
                request.getCity());

        agent.setState(
                request.getState());

        agent.setCountry(
                request.getCountry());

        agent.setPincode(
                request.getPincode());

        agent.setStatus(
                ApprovalStatus.PENDING);

        agentRepository.save(agent);

        emailOtpRepository.deleteByEmailAndPurpose(
                request.getEmail(),
                "REGISTER");

        return new ApiResponse(
                "Agent Registered Successfully");
    }

}