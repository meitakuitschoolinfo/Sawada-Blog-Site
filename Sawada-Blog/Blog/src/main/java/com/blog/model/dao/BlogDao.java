package com.blog.model.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.model.entity.BlogEntity;

@Repository
public interface BlogDao extends JpaRepository<BlogEntity, Long> {
	List<BlogEntity> findByUserId(Long userId);

	BlogEntity seve(BlogEntity blogEntity);

	BlogEntity findByBlogTitleAndRegisterDate(String blogTitle, LocalDate registerDate);

	BlogEntity findByBlogId(Long blogId);

	List<BlogEntity> deleteByBlogId(Long blogId);
}
