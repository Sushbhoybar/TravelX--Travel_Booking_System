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

    /*
     * Documents are OPTIONAL during update.
     * If a new file is uploaded, replace the existing one.
     * Otherwise keep the existing document.
     */

    private MultipartFile insuranceDocument;

    private MultipartFile registrationCertificate;

    private MultipartFile fitnessCertificate;

    private MultipartFile permitDocument;

    private MultipartFile pollutionCertificate;

    /*
     * Optional.
     * If images are uploaded, replace old images.
     * Otherwise keep existing images.
     */
    private List<MultipartFile> busImages;

}