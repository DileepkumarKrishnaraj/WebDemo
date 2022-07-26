package com.samco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping(value = "/welcome")
	public String homePageCaller() {
		return "home";
	}
}
