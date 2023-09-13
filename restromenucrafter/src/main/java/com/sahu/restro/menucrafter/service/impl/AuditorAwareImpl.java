package com.sahu.restro.menucrafter.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import com.sahu.restro.menucrafter.constants.CommonConstants;
import com.sahu.restro.menucrafter.model.User;
import com.sahu.restro.menucrafter.security.SecurityUtil;
import com.sahu.restro.menucrafter.service.UserService;
import com.sahu.restro.menucrafter.service.dto.CustomLoginUserDTO;


@Service
public class AuditorAwareImpl implements AuditorAware<Long> {

	@Autowired
	private UserService  userService;
	
	@Override
	public Optional<Long> getCurrentAuditor() {
		CustomLoginUserDTO userDetailsDTO = SecurityUtil.getCurrentUser();
		if (userDetailsDTO != null) {
			return Optional.of(userDetailsDTO.getUserId());
		} else {
			Optional<User> user = userService.findByEmail(CommonConstants.SUPPORT_EMAIL);
			return Optional.of(user.get().getId());
		}
	}

}
