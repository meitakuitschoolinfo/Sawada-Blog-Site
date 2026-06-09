package com.blog.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.model.dao.UserDao;
import com.blog.model.entity.UserEntity;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public boolean createAccount(String userName, String email, String password) {
		LocalDateTime registerDate = LocalDateTime.now();
		if(userDao.findByEmail(email) == null) {
			userDao.save(new UserEntity(userName, email, password, registerDate));
			return true;
		} else {
			return false;
		}
	}
	
	public UserEntity loginAccount(String email, String password) {
		if(userDao.findByEmailAndPassword(email, password) == null) {
			return null;
		} else {
			return userDao.findByEmailAndPassword(email, password);
		}
	}
}
