package com.serosoft.development.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.serosoft.development.test.dao.UserDAO;
import com.serosoft.development.test.entity.User;
import com.serosoft.development.test.service.UserService;

/**
 * @author Nikhil Sanghvi
 * @version 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		System.out.println("UserServiceImpl()");
	}

	@Autowired
	private UserDAO userDAO;

	@Override
	public long createUser(User user) {
		return userDAO.createUser(user);
	}

	@Override
	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}

	@Override
	public void deleteUser(long id) {
		userDAO.deleteUser(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public User getUser(long id) {
		return userDAO.getUser(id);
	}

}