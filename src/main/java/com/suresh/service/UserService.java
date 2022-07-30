package com.suresh.service;

import java.util.List;

import com.suresh.bindings.UserRequest;
import com.suresh.entities.RegisterUser;

public interface UserService {

	public String saveUser(UserRequest request);
	public List<RegisterUser> getAllUsers();
}
