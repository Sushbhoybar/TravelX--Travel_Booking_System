package com.busbooking.dtos;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.busbooking.entities.BusType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBusRequest {
    
    @NotBlank(message = "Bus Name is required")
    private String busName;

    @NotNull(message = "Bus Type is required")
    private BusType busType;

    @NotNull(message = "Total Seats is required")
    @Min(value = 1, message = "Total Seats must be greater than 0")
    private Integer totalSeats;

    private String amenities;

    // Documents

    @NotNull(message = "Insurance Document is required")
    private MultipartFile insuranceDocument;

    @NotNull(message = "Registration Certificate is required")
    private MultipartFile registrationCertificate;

    @NotNull(message = "Fitness Certificate is required")
    private MultipartFile fitnessCertificate;

    @NotNull(message = "Permit Document is required")
    private MultipartFile permitDocument;

    @NotNull(message = "Pollution Certificate is required")
    private MultipartFile pollutionCertificate;

    // Multiple Bus Images

    private List<MultipartFile> busImages;

}