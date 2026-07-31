package com.busbooking.services;

import java.util.List;

import com.busbooking.dtos.ApiResponse;
import com.busbooking.dtos.CreateRouteRequest;
import com.busbooking.dtos.RouteResponse;

public interface RouteService {

    ApiResponse addRoute(CreateRouteRequest request);

    List<RouteResponse> getAllRoutes();

    RouteResponse getRouteById(Long routeId);

    ApiResponse deleteRoute(Long routeId);

}