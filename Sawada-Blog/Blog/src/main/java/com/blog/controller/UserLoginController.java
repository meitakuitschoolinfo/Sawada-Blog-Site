package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserLoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/user/login")
	public String getUserLoginPage() {
		return "login.html";
	}
	
	@PostMapping("/user/login/process")
	public String login(@RequestParam String email, @RequestParam String password) {
		//System.out.println(email + password);
		if(userService.loginAccount(email, password) == null) {
			return "redirect:/user/login";
		} else {
			session.setAttribute("LoginInfo", userService.loginAccount(email, password));    // loginAccountの情報を
			return "redirect:/user/blog/list";
		}
	}
	
	
}
