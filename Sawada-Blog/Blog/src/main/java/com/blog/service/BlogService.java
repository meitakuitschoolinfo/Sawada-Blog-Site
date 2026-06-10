package com.blog.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.dao.BlogDao;
import com.blog.model.entity.BlogEntity;
import com.blog.model.entity.UserEntity;

@Service
public class BlogService {
	@Autowired
	private BlogDao blogDao;
	
	public List<BlogEntity> findAllBlogPost(Long userId){
		if(blogDao.findByUserId(userId) == null) {
			return null;
		} else {
			return blogDao.findByUserId(userId);
		}
	}
	
	public boolean createBlogPost(String blogTitle, LocalDate registerDate, String fileName, String blogDetail, String Category, Long userId) {
		if(blogDao.findByBlogTitleAndRegisterDate(blogTitle, registerDate) == null) {
			blogDao.save(new BlogEntity(blogTitle, registerDate, fileName, blogDetail, Category, userId));
			return true;
		} else {
			return false;
		}
	}
	
	public BlogEntity getBlogPost(Long blogId) {
		if(blogDao.findByBlogId(blogId) == null) {
			return null;
		} else {
			return blogDao.findByBlogId(blogId);
		}
	}
	
	public boolean editBlogPost(String blogTitle, LocalDate registerDate, String blogDetail, String category, Long userId, Long blogId) {
		BlogEntity blogEntity = blogDao.findByBlogId(blogId);
		if(userId == null) {
			return false;
		} else {
			blogEntity.setBlogTitle(blogTitle);
			blogEntity.setRegisterDate(registerDate);
			blogEntity.setBlogDetail(blogDetail);
			blogEntity.setCategory(category);
			blogDao.save(blogEntity);
			return true;
		}
	}
	
	public boolean editBlogImage (Long blogId, String fileName, Long userId) {
		BlogEntity blogEntity = blogDao.findByBlogId(blogId);
		if(fileName == null||fileName.equals(fileName)) {
			return false;
		} else {
			blogEntity.setBlogImage(fileName);
			blogEntity.setUserId(userId);
			blogDao.save(blogEntity);
			return true;
		}
	}
	
	public boolean deleteBlog(Long blogId) {
		if(blogId == null) {
			return false;
		}else {
			blogDao.deleteByBlogId(blogId);
			return true;
		}
	}
}
