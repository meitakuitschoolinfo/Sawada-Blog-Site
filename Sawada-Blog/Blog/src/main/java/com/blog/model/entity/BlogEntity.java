package com.blog.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BlogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long blogId;
	private String blogTitle;
	private LocalDate registerDate;
	private String blogImage;
	private String blogDetail;
	private String category;
	private Long userId;

	public BlogEntity() {

	}

	public BlogEntity(String blogTitle, LocalDate registerDate, String blogImage, String blogDetail, String category,
			Long userId) {
		super();
		this.blogTitle = blogTitle;
		this.registerDate = registerDate;
		this.blogImage = blogImage;
		this.blogDetail = blogDetail;
		this.category = category;
		this.userId = userId;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public String getBlogImage() {
		return blogImage;
	}

	public void setBlogImage(String blogImage) {
		this.blogImage = blogImage;
	}

	public String getBlogDetail() {
		return blogDetail;
	}

	public void setBlogDetail(String blogDetail) {
		this.blogDetail = blogDetail;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
