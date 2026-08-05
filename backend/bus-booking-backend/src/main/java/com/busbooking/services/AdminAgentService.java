package com.busbooking.services;

import java.util.List;

import com.busbooking.dtos.AgentDetailsResponse;
import com.busbooking.dtos.AgentResponse;
import com.busbooking.dtos.ApiResponse;

public interface AdminAgentService {

    List<AgentResponse> getAllAgents();

    AgentDetailsResponse getAgentDetails(Long userId);

    ApiResponse approveAgent(Long userId);

    ApiResponse rejectAgent(Long userId);
    
    ApiResponse suspendAgent(Long userId);

    ApiResponse activateAgent(Long userId);

}