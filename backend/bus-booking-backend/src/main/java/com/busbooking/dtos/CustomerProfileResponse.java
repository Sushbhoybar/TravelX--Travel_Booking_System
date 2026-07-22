package com.busbooking.dtos;

import com.busbooking.entities.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerProfileResponse {

    private Long userId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phone;

    private Gender gender;
}