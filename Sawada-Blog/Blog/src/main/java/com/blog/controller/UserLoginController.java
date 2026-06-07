package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLoginController {
	@GetMapping("/user/login")
	public String getUserLoginPage() {
		return "login.html";
	}
	
	@PostMapping("/user/login/process")
	public String login(@RequestParam String email, @RequestParam String password) {
		if(userService.loginAccount(email, password) == null) {
			return "redirect:/user/blog/list";
		} else {
			return "redirect:/user/login";
		}
	}
}
