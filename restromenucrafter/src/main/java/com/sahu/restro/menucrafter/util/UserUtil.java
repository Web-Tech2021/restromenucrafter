package com.sahu.restro.menucrafter.util;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.sahu.restro.menucrafter.constants.Status;
import com.sahu.restro.menucrafter.model.User;
import com.sahu.restro.menucrafter.service.UserService;

@Component
public class UserUtil {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public Long registerUser(User user) {
		user.setUuid(UUID.randomUUID().toString());
		user.setStatus(Status.ACTIVE);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setActive(true);
		return userService.save(user).getId();
	}

	public User getTokenForReset(User user) {
		String restPasswordToken = UUID.randomUUID().toString();
		user.setResetPasswordToken(restPasswordToken);
		return userService.save(user);
	}
	
	public User updatePassword(User user, String newPassword) {
		user.setPassword(passwordEncoder.encode(newPassword));
		user.setResetPasswordToken(null);
		return userService.save(user);
	}
	
}
