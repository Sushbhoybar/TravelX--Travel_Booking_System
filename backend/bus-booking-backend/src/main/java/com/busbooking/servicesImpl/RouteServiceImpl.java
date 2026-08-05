package com.busbooking.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.busbooking.custom_exception.DuplicateResourceException;
import com.busbooking.custom_exception.ResourceNotFoundException;
import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.RouteRequest;
import com.busbooking.dtos.RouteResponse;
import com.busbooking.entities.Route;
import com.busbooking.repository.RouteRepository;
import com.busbooking.services.RouteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RouteServiceImpl implements RouteService {

    private static final Logger logger =
            LoggerFactory.getLogger(RouteServiceImpl.class);

    private final RouteRepository routeRepository;

    @Override
    public ApiResponse addRoute(RouteRequest request) {

    	logger.info(
                "Adding new route {} -> {}",
                request.getSourceCity(),
                request.getDestinationCity());

        // Normalize input
        request.setSourceCity(
                request.getSourceCity().trim());

        request.setDestinationCity(
                request.getDestinationCity().trim());

        if (routeRepository.existsBySourceCityAndDestinationCity(
                request.getSourceCity(),
                request.getDestinationCity())) {

            throw new DuplicateResourceException(
                    "Route already exists");
        }

        Route route = new Route();

        route.setSourceCity(
                request.getSourceCity());

        route.setDestinationCity(
                request.getDestinationCity());

        route.setDistanceKm(
                request.getDistanceKm());

        route.setEstimatedDurationMinutes(
                request.getEstimatedDurationMinutes());

        route.setActive(
                request.getActive());

        routeRepository.save(route);

        logger.info(
                "Route added successfully");

        return new ApiResponse(
                "Route Added Successfully");
    }

    @Override
    @Transactional(readOnly = true)
    public List<RouteResponse> getAllRoutes() {

        logger.info("Fetching all routes");

        List<Route> routes =
                routeRepository.findAll();

        List<RouteResponse> response =
                new ArrayList<>();

        for (Route route : routes) {

            RouteResponse dto =
                    new RouteResponse();

            dto.setRouteId(
                    route.getRouteId());

            dto.setSourceCity(
                    route.getSourceCity());

            dto.setDestinationCity(
                    route.getDestinationCity());

            dto.setDistanceKm(
                    route.getDistanceKm());
            
            dto.setEstimatedDurationMinutes(
                    route.getEstimatedDurationMinutes());

            dto.setActive(
                    route.getActive());

            response.add(dto);
        }

        logger.info(
                "{} routes found",
                response.size());

        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public RouteResponse getRoute(Long routeId) {

        logger.info("Fetching route {}", routeId);

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Route not found"));

        RouteResponse dto = new RouteResponse();

        dto.setRouteId(route.getRouteId());

        dto.setSourceCity(route.getSourceCity());

        dto.setDestinationCity(route.getDestinationCity());

        dto.setDistanceKm(route.getDistanceKm());
        
        dto.setEstimatedDurationMinutes(
                route.getEstimatedDurationMinutes());

        dto.setActive(
                route.getActive());

        return dto;
    }

    @Override
    public ApiResponse updateRoute(
            Long routeId,
            RouteRequest request) {

        logger.info("Updating route {}", routeId);

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Route not found"));

        // Normalize input
        request.setSourceCity(
                request.getSourceCity().trim());

        request.setDestinationCity(
                request.getDestinationCity().trim());

        route.setSourceCity(
                request.getSourceCity());

        route.setDestinationCity(
                request.getDestinationCity());

        route.setDistanceKm(
                request.getDistanceKm());

        route.setEstimatedDurationMinutes(
                request.getEstimatedDurationMinutes());

        route.setActive(
                request.getActive());

        routeRepository.save(route);

        return new ApiResponse(
                "Route Updated Successfully");
    }

    @Override
    public ApiResponse deleteRoute(Long routeId) {

        logger.info("Deleting route {}", routeId);

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Route not found"));

        routeRepository.delete(route);

        logger.info("Route deleted successfully");

        return new ApiResponse(
                "Route Deleted Successfully");
    }

}
