package com.busbooking.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendOtpRequest {

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email is required")
    private String email;
}