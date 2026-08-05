package com.busbooking.services;

import java.util.List;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.RouteRequest;
import com.busbooking.dtos.RouteResponse;

public interface RouteService {

    ApiResponse addRoute(RouteRequest request);

    List<RouteResponse> getAllRoutes();

    RouteResponse getRoute(Long routeId);

    ApiResponse updateRoute(
            Long routeId,
            RouteRequest request);

    ApiResponse deleteRoute(
            Long routeId);

}