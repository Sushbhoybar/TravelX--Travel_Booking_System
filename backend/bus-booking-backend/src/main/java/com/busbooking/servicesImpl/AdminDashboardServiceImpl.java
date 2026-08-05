package com.busbooking.servicesImpl;

import org.springframework.stereotype.Service;

import com.busbooking.dtos.AdminDashboardResponse;
import com.busbooking.entities.BusStatus;
import com.busbooking.entities.UserRole;
import com.busbooking.repository.AgentRepository;
import com.busbooking.repository.BusRepository;
import com.busbooking.repository.RouteRepository;
import com.busbooking.repository.UserRepository;
import com.busbooking.services.AdminDashboardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminDashboardServiceImpl
        implements AdminDashboardService {

    private final UserRepository userRepository;

    private final AgentRepository agentRepository;

    private final BusRepository busRepository;

    private final RouteRepository routeRepository;

    @Override
    public AdminDashboardResponse getDashboard() {

        AdminDashboardResponse dto =
                new AdminDashboardResponse();

        dto.setTotalUsers(
                userRepository.count());

        dto.setTotalCustomers(
                userRepository.countByRole(UserRole.CUSTOMER));

        dto.setTotalAgents(
                userRepository.countByRole(UserRole.AGENT));
        
        dto.setTotalBuses(
                busRepository.count());

        dto.setPendingBuses(
                busRepository.countByStatus(
                        BusStatus.PENDING));

        dto.setApprovedBuses(
                busRepository.countByStatus(
                        BusStatus.APPROVED));

        dto.setRejectedBuses(
                busRepository.countByStatus(
                        BusStatus.REJECTED));

        return dto;

    }

}