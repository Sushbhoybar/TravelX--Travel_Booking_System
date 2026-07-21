package com.busbooking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busbooking.dtos.LoginReq;
import com.busbooking.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService userServices;
	
	/*
	 * Desc - Agent Login / Admin Login / Customer (User Login)
	URL - http://host:port/users/signin
	Method - POST  
	Payload - email , password  - (json) -> AuthRequest - DTO 
	Success Resp -SC 200   Auth Resp (user id ,name, email , role , message)
	Failure Resp - SC 401 ApiResp DTO(status :  failure , timestamp , message)
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> userLogin(@RequestBody @Valid LoginReq req){
		System.out.println("in user sign in "+req);
		
		return ResponseEntity.ok(userServices.authenticateUser(req));
		
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers(){
		return ResponseEntity.ok(userServices.getAllUsers());
	}

}
