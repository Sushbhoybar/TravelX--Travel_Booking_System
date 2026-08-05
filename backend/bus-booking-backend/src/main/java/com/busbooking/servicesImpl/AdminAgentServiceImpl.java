package com.busbooking.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busbooking.custom_exception.ResourceNotFoundException;
import com.busbooking.dtos.AgentDetailsResponse;
import com.busbooking.dtos.AgentResponse;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.entities.Agent;
import com.busbooking.entities.ApprovalStatus;
import com.busbooking.repository.AgentRepository;
import com.busbooking.services.AdminAgentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminAgentServiceImpl
        implements AdminAgentService {

    private final AgentRepository agentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AgentResponse> getAllAgents() {

        List<Agent> agents =
                agentRepository.findAllByOrderByStatusAscAgencyNameAsc();

        List<AgentResponse> response =
                new ArrayList<>();

        for (Agent agent : agents) {

            AgentResponse dto =
                    new AgentResponse();

            dto.setUserId(
                    agent.getUserId());

            dto.setAgencyName(
                    agent.getAgencyName());

            dto.setOwnerName(
                    agent.getUser().getFirstName()
                            + " "
                            + agent.getUser().getLastName());

            dto.setEmail(
                    agent.getUser().getEmail());

            dto.setPhone(
                    agent.getUser().getPhone());

            dto.setCity(
                    agent.getCity());

            dto.setStatus(
                    agent.getStatus());

            response.add(dto);

        }

        return response;

    }

    @Override
    @Transactional(readOnly = true)
    public AgentDetailsResponse getAgentDetails(
            Long userId) {

        Agent agent =
                agentRepository.findByUserUserId(userId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Agent not found"));

        AgentDetailsResponse dto =
                new AgentDetailsResponse();

        dto.setUserId(agent.getUserId());

        dto.setAgencyName(agent.getAgencyName());

        dto.setOwnerName(
                agent.getUser().getFirstName()
                        + " "
                        + agent.getUser().getLastName());

        dto.setEmail(
                agent.getUser().getEmail());

        dto.setPhone(
                agent.getUser().getPhone());

        dto.setGstNumber(
                agent.getGstNumber());

        dto.setPanNumber(
                agent.getPanNumber());

        dto.setBusinessLicense(
                agent.getBusinessLicense());

        dto.setAccountHolderName(
                agent.getAccountHolderName());

        dto.setBankAccountNumber(
                agent.getBankAccountNumber());

        dto.setIfscCode(
                agent.getIfscCode());

        dto.setAddress(
                agent.getAddress());

        dto.setCity(
                agent.getCity());

        dto.setState(
                agent.getState());

        dto.setCountry(
                agent.getCountry());

        dto.setPincode(
                agent.getPincode());

        dto.setStatus(
                agent.getStatus());

        return dto;

    }

    @Override
    public ApiResponse approveAgent(
            Long userId) {

        Agent agent =
                agentRepository.findByUserUserId(userId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Agent not found"));

        if (agent.getStatus() == ApprovalStatus.APPROVED) {

            return new ApiResponse(
                    "Agent is already approved");

        }

        agent.setStatus(
                ApprovalStatus.APPROVED);

        agentRepository.save(agent);

        return new ApiResponse(
                "Agent Approved Successfully");

    }

    @Override
    public ApiResponse rejectAgent(
            Long userId) {

        Agent agent =
                agentRepository.findByUserUserId(userId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Agent not found"));

        if (agent.getStatus() == ApprovalStatus.REJECTED) {

            return new ApiResponse(
                    "Agent is already rejected");

        }

        agent.setStatus(
                ApprovalStatus.REJECTED);

        agentRepository.save(agent);

        return new ApiResponse(
                "Agent Rejected Successfully");

    }

    @Override
    public ApiResponse suspendAgent(Long userId) {

        Agent agent =
                agentRepository.findByUserUserId(userId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Agent not found"));

        if (agent.getStatus() != ApprovalStatus.APPROVED) {

            return new ApiResponse(
                    "Only approved agents can be suspended");

        }

        agent.setStatus(
                ApprovalStatus.SUSPENDED);

        agentRepository.save(agent);

        return new ApiResponse(
                "Agent Suspended Successfully");

    }

    @Override
    public ApiResponse activateAgent(Long userId) {

        Agent agent =
                agentRepository.findByUserUserId(userId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Agent not found"));

        if (agent.getStatus() != ApprovalStatus.SUSPENDED) {

            return new ApiResponse(
                    "Only suspended agents can be activated");

        }

        agent.setStatus(
                ApprovalStatus.APPROVED);

        agentRepository.save(agent);

        return new ApiResponse(
                "Agent Activated Successfully");

    }

}