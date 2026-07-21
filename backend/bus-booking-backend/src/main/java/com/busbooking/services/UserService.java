package com.busbooking.services;

import java.util.List;
import com.busbooking.dtos.LoginReq;
import com.busbooking.dtos.LoginResp;
import com.busbooking.entities.User;

public interface UserService {
	LoginResp authenticateUser(LoginReq request);

	List<User> getAllUsers();
}
