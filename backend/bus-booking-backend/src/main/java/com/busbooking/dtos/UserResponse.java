package com.busbooking.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {

    private Long userId;
    private String name;
    private String email;
    private String phone;
    private String role;
    private Boolean isActive;

}