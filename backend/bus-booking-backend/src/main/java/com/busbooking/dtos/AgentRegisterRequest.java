package com.busbooking.dtos;

import com.busbooking.entities.Gender;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgentRegisterRequest {

    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String phone;

    @Size(min = 6)
    private String password;

    private Gender gender;

    @NotBlank
    private String agencyName;

    @NotBlank
    private String gstNumber;

    @NotBlank
    private String panNumber;

    @NotBlank
    private String businessLicense;

    @NotBlank
    private String bankAccountNumber;

    @NotBlank
    private String ifscCode;

    @NotBlank
    private String accountHolderName;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String country;

    @NotBlank
    private String pincode;

}