package com.serosoft.development.test.service;

import java.util.List;

import com.serosoft.development.test.entity.User;

/**
 * @author Nikhil Sanghvi
 */
public interface UserService {
	public long createUser(User user);

	public User updateUser(User user);

	public void deleteUser(long id);

	public List<User> getAllUsers();

	public User getUser(long id);

}