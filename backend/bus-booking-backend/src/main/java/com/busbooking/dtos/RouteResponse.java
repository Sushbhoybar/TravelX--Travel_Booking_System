package com.busbooking.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RouteResponse {

    private Long routeId;

    private String source;

    private String destination;

    private Integer distanceKm;

}