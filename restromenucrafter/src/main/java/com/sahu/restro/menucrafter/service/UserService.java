package com.sahu.restro.menucrafter.service;

import java.util.Optional;

import com.sahu.restro.menucrafter.model.User;

public interface UserService {

	public Optional<User> findByEmail(String email);

	public User save(User user);
	
	public Optional<User> findByResetPasswordToken(String resetPasswordToken);

}
