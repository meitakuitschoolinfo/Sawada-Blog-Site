package com.blog.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.blog.model.entity.UserEntity;
import com.blog.service.BlogService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogRegisterController {
	@Autowired
	private BlogService blogService;

	@Autowired
	private HttpSession session;

	@GetMapping("/user/blog/register")
	public String getBlogRegisterPage(Model model) {
		UserEntity userEntity = (UserEntity) session.getAttribute("LoginInfo");

		String userName = userEntity.getUserName();

		model.addAttribute("userName", userName);

		return "blog-register.html";
	}

	@PostMapping("/user/blog/register/process")
	public String blogRegister(String blogTitle, LocalDate registerDate, String category, MultipartFile blogImage, String blogDetail, Model model) {
		UserEntity userEntity = (UserEntity) session.getAttribute("LoginInfo");
		
		Long userId	= userEntity.getUserId();
		
		String fileName = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss-").format(new Date()) + blogImage.getOriginalFilename();
		
		try {
			Files.copy(blogImage.getInputStream(), Path.of("src/main/resources/static/blog-img/" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (blogService.createBlogPost(blogTitle, registerDate, fileName, blogDetail, category, userId)){
				return "blog-register-fix.html";
			} else {
				return "blog-register.html";
			}
		}
}
