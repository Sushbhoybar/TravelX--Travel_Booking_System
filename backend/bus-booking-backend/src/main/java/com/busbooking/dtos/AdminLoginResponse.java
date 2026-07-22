package com.busbooking.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AdminLoginResponse {

    private Long userId;
    private String fullName;
    private String email;
    private String message;

}