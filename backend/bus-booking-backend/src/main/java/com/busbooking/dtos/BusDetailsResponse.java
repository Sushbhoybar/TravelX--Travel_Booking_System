package com.busbooking.dtos;

import java.util.List;

import com.busbooking.entities.BusStatus;
import com.busbooking.entities.BusType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusDetailsResponse {

    private Long busId;

    private String busName;

    private String registrationNumber;

    private BusType busType;

    private Integer totalSeats;

    private String amenities;

    private String insuranceDocument;

    private String registrationCertificate;

    private String fitnessCertificate;

    private String permitDocument;

    private String pollutionCertificate;

    private BusStatus status;

    private List<String> imageUrls;

}