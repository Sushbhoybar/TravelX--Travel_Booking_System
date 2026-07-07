package com.busbooking.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoginReq {
	private String email;
	private String password;
	
}
