package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.blog.model.entity.BlogEntity;
import com.blog.model.entity.UserEntity;
import com.blog.service.BlogService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogListController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private HttpSession session;
	
	@GetMapping("/user/blog/list")
	public String getBlogListPage(Model model) {
		UserEntity userEntity = (UserEntity) session.getAttribute("UserInfo");
		
		Long userId = userEntity.getUserId();
		String userName = userEntity.getUserName();
		
		List<BlogEntity> blogList = blogService.findAllBlogPost(userId);
		
		model.addAttribute("userName", userName);
		model.addAttribute("blogList", blogList);
		
		return "blog-list.html";
		
	}
}
