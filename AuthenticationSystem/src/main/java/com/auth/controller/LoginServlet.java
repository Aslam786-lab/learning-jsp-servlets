package com.auth.controller;

import java.io.IOException;

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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get username and password from form
		String username = request.getParameter("user_name");
		String password = request.getParameter("user_password");
		
		
		
		UserDao dao = new UserDao();
		User u = dao.userNamePasswordAuth(username, password);
		
		if(u.getName() == null) {
			HttpSession s = request.getSession();
			s.setAttribute("msg", "Invalid username or password");
			response.sendRedirect(request.getContextPath()+"login.jsp");
		}else {
			HttpSession s= request.getSession();
			s.setAttribute("username", u.getName());
			s.setAttribute("city", u.getCity());
			s.setAttribute("age", u.getAge());
			s.setAttribute("gender", u.getGender());
			s.setAttribute("password", u.getPassword());
			
			response.sendRedirect("/account/profile.jsp");
		}
		

		
	}
	


}
