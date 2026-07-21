package com.busbooking.dtos;

import com.busbooking.entities.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResp {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private UserRole role;
	private String message;
}
