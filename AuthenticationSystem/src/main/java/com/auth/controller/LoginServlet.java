package com.auth.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.auth.dao.UserDao;
import com.auth.entities.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	Logger log = Logger.getLogger("LoginServlet");
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get username and password from form
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		System.out.println("LoginServlet");
		log.warning("Processing email and password in LoginServlet");
		
		
		UserDao dao = new UserDao();
		List<User> user=dao.emailPasswordAuth(email, password);
		System.out.println(user);
		System.out.println(user.size());
		if(user.size() == 0) {
			HttpSession s = request.getSession();
			s.setAttribute("msg", "Invalid email or password");
			response.sendRedirect("/user-login");
		}else {
			HttpSession s= request.getSession();
			user.forEach((u)->{
				s.setAttribute("username", u.getName());
				s.setAttribute("email", u.getEmail());
				s.setAttribute("city", u.getCity());
				s.setAttribute("age", u.getAge());
				s.setAttribute("gender", u.getGender());
				s.setAttribute("password", u.getPassword());
			});
			System.out.println("user stored in session");
			response.sendRedirect("/user-profile");
		}
		

		
	}
	


}
