package com.serosoft.development.test.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.serosoft.development.test.entity.User;
import com.serosoft.development.test.service.UserService;

/**
 * @author Nikhil Sanghvi
 * @version 1.0
 */
@Controller
public class UserController {

	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("createUser")
	public ModelAndView createUser(@ModelAttribute User user) {
		logger.info("Creating User. Data: " + user);
		return new ModelAndView("userForm");
	}

	@RequestMapping("editUser")
	public ModelAndView editUser(@RequestParam long id, @ModelAttribute User user) {
		logger.info("Updating the User for the Id " + id);
		user = userService.getUser(id);
		return new ModelAndView("userForm", "userObject", user);
	}

	@RequestMapping("saveUser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		logger.info("Saving the User. Data : " + user);
		if (user.getId() == 0) { // if user id is 0 then creating the user other
									// updating the user
			userService.createUser(user);
		} else {
			userService.updateUser(user);
		}
		return new ModelAndView("redirect:getAllUsers");
	}

	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(@RequestParam long id) {
		logger.info("Deleting the User. Id : " + id);
		userService.deleteUser(id);
		return new ModelAndView("redirect:getAllUsers");
	}

	@RequestMapping(value = { "getAllUsers", "/" })
	public ModelAndView getAllUsers() {
		logger.info("Getting the all Users.");
		List<User> userList = userService.getAllUsers();
		for (User user : userList) {
			System.out.println("First Name: " + user.getFirstName());
			System.out.println("Last Name: " + user.getLastName());
			System.out.println("Sex: " + user.getSex());
			System.out.println("Phone No: " + user.getPhoneNo());
			System.out.println("Email Id: " + user.getEmailId());
			System.out.println("Address: " + user.getAddress());
		}
		return new ModelAndView("userList", "userList", userList);
	}

}