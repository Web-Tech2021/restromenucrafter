package com.sahu.restro.menucrafter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sahu.restro.menucrafter.constants.LVNConstants;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showIndexPage() {
		return LVNConstants.LOGIN_PAGE;
	}
}
