package com.sahu.restro.menucrafter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sahu.restro.menucrafter.constants.LVNConstants;

@Controller
@RequestMapping("/client/admin")
public class AdminController {

	@GetMapping("/dashboard")
	public String showDashBoardPage() {
		return LVNConstants.ADMIN_DASHBOARD_PAGE;
	}

}
