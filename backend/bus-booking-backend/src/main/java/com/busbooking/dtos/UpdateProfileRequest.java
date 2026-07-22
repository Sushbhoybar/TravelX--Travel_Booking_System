package com.busbooking.dtos;

import com.busbooking.entities.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProfileRequest {

    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Invalid Mobile Number"
    )
    private String phone;

    private Gender gender;
}