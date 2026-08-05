package com.busbooking.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RejectBusRequest {

    @NotBlank(message = "Remarks are required")
    @Size(max = 1000,
            message = "Remarks cannot exceed 1000 characters")
    private String remarks;

}