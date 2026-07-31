package com.busbooking.services;

import com.busbooking.dtos.AgentRegisterRequest;
import com.busbooking.dtos.ApiResponse;

public interface AgentService {

    ApiResponse registerAgent(
            AgentRegisterRequest request);

}