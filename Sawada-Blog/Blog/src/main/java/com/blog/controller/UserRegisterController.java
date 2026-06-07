package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.service.UserService;

@Controller
public class UserRegisterController {
@Autowired
private UserService userService;
	@GetMapping("/uer/register")
	public String getUserRegisterPage() {
		return "register.html";
	}
	
	@PostMapping("/user/register/process")
	public String register(@RequestParam String userName, @RequestParam String email, @RequestParam String password) {
		if(UserService.createAccount(userName, email, password)) {
			return "redirect:/user/login";
		}else {
			return "redirect:/user/login";
		}
	}
}
