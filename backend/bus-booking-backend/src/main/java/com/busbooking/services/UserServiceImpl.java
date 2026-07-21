package com.busbooking.services;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.busbooking.custom_exception.AuthenticationFailedException;
import com.busbooking.dtos.LoginReq;
import com.busbooking.dtos.LoginResp;
import com.busbooking.entities.User;
import com.busbooking.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepo;
	private final ModelMapper mapper;
	
	@Override
	public LoginResp authenticateUser(LoginReq request) {
		User user = userRepo.findByEmailAndPasswordHash(request.getEmail(), request.getPassword()).orElseThrow(()->new AuthenticationFailedException("Invalid email or password!!!!"));
		LoginResp resp = mapper.map(user, LoginResp.class);
		resp.setMessage("Login Successful !");
		return resp;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepo.findAll();
		return users;
	}

}
