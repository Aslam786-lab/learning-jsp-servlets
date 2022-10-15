package com.auth.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import com.auth.controller.RegisterServlet;
import com.auth.entities.User;
public class UserDao {
	
	public List<User> emailPasswordAuth(String email, String password) {
		RegisterServlet register = new RegisterServlet();
		List<User> userList=ofy().load().type(User.class)
				.filter("email =", email)
				.filter("password =", register.getPasswordHash(password))
				.list();
		System.out.println("before user");
		
		return userList;
		

	}
}
