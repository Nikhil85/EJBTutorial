package com.serosoft.development.test.dao.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.serosoft.development.test.dao.UserDAO;
import com.serosoft.development.test.entity.User;
import com.serosoft.development.test.utility.HibernateUtil;

/**
 * @author Nikhil Sanghvi
 */

@Repository
public class UserDAOImpl implements UserDAO {

	public UserDAOImpl() {
		System.out.println("UserDAOImpl");
	}

	@Autowired
	private HibernateUtil hibernateUtil;

	@Override
	public long createUser(User user) {
		return (Long) hibernateUtil.create(user);
	}

	@Override
	public User updateUser(User user) {
		return hibernateUtil.update(user);
	}

	@Override
	public void deleteUser(long id) {
		User user = new User();
		user.setId(id);
		hibernateUtil.delete(user);
	}

	@Override
	public List<User> getAllUsers() {
		return hibernateUtil.fetchAll(User.class);
	}

	@Override
	public User getUser(long id) {
		return hibernateUtil.fetchById(id, User.class);
	}

}