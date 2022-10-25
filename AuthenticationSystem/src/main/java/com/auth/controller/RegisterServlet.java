package com.auth.controller;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import com.auth.entities.User;
import com.googlecode.objectify.Key;

/*
Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	Logger log = Logger.getLogger("RegisterServlet");
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String city = request.getParameter("user_city");
		int age = Integer.parseInt((String)request.getParameter("user_age")) ;
		String gender = request.getParameter("user_gender");
		String password = getPasswordHash(request.getParameter("user_password"));
		
		System.out.println("RegisterServlet");
		User user = new User(name,email,city,age,gender,password);
		System.out.println("User key--------"+Key.create(User.class,"user"));
		ofy().save().entity(user).now();

		
		HttpSession session = request.getSession();
		
		session.setAttribute("registered", "successfully registered please login");
		response.sendRedirect("/user-login");

		
		
	}
	
	public String getPasswordHash(String password) {
		String hashValue = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes("UTF-8"));
			hashValue = DatatypeConverter.printHexBinary(hash);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hashValue;
	}
}
