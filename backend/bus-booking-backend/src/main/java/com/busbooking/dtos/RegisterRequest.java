package com.busbooking.dtos;

import com.busbooking.entities.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @NotBlank(message = "First Name is required")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email is required")
    private String email;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid Mobile Number")
    private String phone;

    private Gender gender;

    @Size(min = 6, message = "Password must contain at least 6 characters")
    private String password;

}