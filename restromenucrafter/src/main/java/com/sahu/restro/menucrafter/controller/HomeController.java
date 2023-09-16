package com.sahu.restro.menucrafter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sahu.restro.menucrafter.constants.LVNConstants;
import com.sahu.restro.menucrafter.constants.PermissionConstants;
import com.sahu.restro.menucrafter.security.SecurityUtil;
import com.sahu.restro.menucrafter.service.dto.CustomUserDetailsDTO;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showIndexPage() {
		CustomUserDetailsDTO customUserDetailsDTO = SecurityUtil.getCurrentUser();
		if (customUserDetailsDTO != null) {
			if (customUserDetailsDTO.hasPermission(PermissionConstants.GLOBAL_ADMINISTRATION))
				return LVNConstants.REDIRECT_ADMIN_DASHBOARD;
			else if (customUserDetailsDTO.hasPermission(PermissionConstants.VIEW_RESTRO_DASHBOARD)) 
				return LVNConstants.REDIRECT_RESTRO_DASHBOARD;
		}
	
		return LVNConstants.INDEX_PAGE;
	}
	
}
