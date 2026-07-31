//package com.busbooking.servicesImpl;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.busbooking.custom_exception.ResourceNotFoundException;
//import com.busbooking.custom_exception.DuplicateResourceException;
//import com.busbooking.dtos.ApiResponse;
//import com.busbooking.dtos.CreateRouteRequest;
//import com.busbooking.dtos.RouteResponse;
//import com.busbooking.entities.Route;
//import com.busbooking.repository.RouteRepository;
//import com.busbooking.services.RouteService;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//@Transactional
//public class RouteServiceImpl implements RouteService {
//
//    private final RouteRepository routeRepository;
//
//    @Override
//    public ApiResponse addRoute(CreateRouteRequest request) {
//
//        if (routeRepository.existsBySourceAndDestination(
//                request.getSource(),
//                request.getDestination())) {
//
//            throw new DuplicateResourceException(
//                    "Route already exists");
//        }
//
//        Route route = new Route();
//
//        route.setSource(request.getSource());
//
//        route.setDestination(request.getDestination());
//
//        route.setDistanceKm(request.getDistanceKm());
//
//        routeRepository.save(route);
//
//        return new ApiResponse("Route Added Successfully");
//    }
//
//    @Override
//    public List<RouteResponse> getAllRoutes() {
//
//        return routeRepository.findAll()
//
//                .stream()
//
//                .map(route -> {
//
//                    RouteResponse response =
//                            new RouteResponse();
//
//                    response.setRouteId(route.getRouteId());
//
//                    response.setSource(route.getSource());
//
//                    response.setDestination(route.getDestination());
//
//                    response.setDistanceKm(route.getDistanceKm());
//
//                    return response;
//
//                })
//
//                .collect(Collectors.toList());
//
//    }
//
//    @Override
//    public RouteResponse getRouteById(Long routeId) {
//
//        Route route = routeRepository.findById(routeId)
//
//                .orElseThrow(() ->
//
//                        new ResourceNotFoundException(
//                                "Route Not Found"));
//
//        RouteResponse response = new RouteResponse();
//
//        response.setRouteId(route.getRouteId());
//
//        response.setSource(route.getSource());
//
//        response.setDestination(route.getDestination());
//
//        response.setDistanceKm(route.getDistanceKm());
//
//        return response;
//
//    }
//
//    @Override
//    public ApiResponse deleteRoute(Long routeId) {
//
//        Route route = routeRepository.findById(routeId)
//
//                .orElseThrow(() ->
//
//                        new ResourceNotFoundException(
//                                "Route Not Found"));
//
//        routeRepository.delete(route);
//
//        return new ApiResponse("Route Deleted Successfully");
//
//    }
//
//}