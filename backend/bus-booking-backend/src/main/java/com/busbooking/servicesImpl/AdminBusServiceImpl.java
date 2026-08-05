package com.busbooking.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busbooking.custom_exception.ResourceNotFoundException;
import com.busbooking.dtos.AdminBusDetailsResponse;
import com.busbooking.dtos.AdminBusResponse;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.RejectBusRequest;
import com.busbooking.entities.Agent;
import com.busbooking.entities.Bus;
import com.busbooking.entities.BusImage;
import com.busbooking.entities.BusStatus;
import com.busbooking.repository.AgentRepository;
import com.busbooking.repository.BusRepository;
import com.busbooking.services.AdminBusService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminBusServiceImpl
        implements AdminBusService {

    private final BusRepository busRepository;

    private final AgentRepository agentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AdminBusResponse> getAllBuses() {

        List<Bus> buses =
                busRepository.findAllByOrderByStatusAscBusNameAsc();

        List<AdminBusResponse> response =
                new ArrayList<>();

        for (Bus bus : buses) {

            Agent agent =
                    agentRepository
                            .findByUserUserId(
                                    bus.getAgent().getUserId())
                            .orElseThrow(() ->
                                    new ResourceNotFoundException(
                                            "Agent not found"));

            AdminBusResponse dto =
                    new AdminBusResponse();

            dto.setBusId(
                    bus.getBusId());

            dto.setAgencyName(
                    agent.getAgencyName());

            dto.setBusName(
                    bus.getBusName());

            dto.setRegistrationNumber(
                    bus.getRegistrationNumber());

            dto.setBusType(
                    bus.getBusType());

            dto.setTotalSeats(
                    bus.getTotalSeats());

            dto.setStatus(
                    bus.getStatus());

            response.add(dto);

        }

        return response;

    }

    @Override
    @Transactional(readOnly = true)
    public AdminBusDetailsResponse getBusDetails(
            Long busId) {

        Bus bus =
                busRepository.findById(busId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Bus not found"));

        Agent agent =
                agentRepository.findByUserUserId(
                        bus.getAgent().getUserId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Agent not found"));

        AdminBusDetailsResponse dto =
                new AdminBusDetailsResponse();

        dto.setBusId(
                bus.getBusId());

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

        dto.setBusName(
                bus.getBusName());

        dto.setRegistrationNumber(
                bus.getRegistrationNumber());

        dto.setBusType(
                bus.getBusType());

        dto.setTotalSeats(
                bus.getTotalSeats());

        dto.setAmenities(
                bus.getAmenities());

        dto.setInsuranceDocument(
                bus.getInsuranceDocument());

        dto.setRegistrationCertificate(
                bus.getRegistrationCertificate());

        dto.setFitnessCertificate(
                bus.getFitnessCertificate());

        dto.setPermitDocument(
                bus.getPermitDocument());

        dto.setPollutionCertificate(
                bus.getPollutionCertificate());

        dto.setStatus(
                bus.getStatus());

        List<String> images =
                new ArrayList<>();

        for (BusImage image : bus.getImages()) {

            images.add(
                    image.getImageUrl());

        }

        dto.setBusImages(images);

        return dto;

    }

    @Override
    public ApiResponse approveBus(
            Long busId) {

        Bus bus =
                busRepository.findById(busId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Bus not found"));

        if (bus.getStatus() ==
                BusStatus.APPROVED) {

            return new ApiResponse(
                    "Bus is already approved");

        }

        bus.setStatus(
                BusStatus.APPROVED);

        bus.setAdminRemarks(null);

        busRepository.save(bus);

        return new ApiResponse(
                "Bus Approved Successfully");

    }

    @Override
    public ApiResponse rejectBus(
            Long busId,
            RejectBusRequest request) {

        Bus bus =
                busRepository.findById(busId)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Bus not found"));

        if (bus.getStatus() ==
                BusStatus.REJECTED) {

            return new ApiResponse(
                    "Bus is already rejected");

        }

        bus.setStatus(
                BusStatus.REJECTED);

        bus.setAdminRemarks(
                request.getRemarks().trim());

        busRepository.save(bus);

        return new ApiResponse(
                "Bus Rejected Successfully");

    }
}