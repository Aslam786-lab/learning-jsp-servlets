package com.auth.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
* Servlet implementation class LogoutServlet
*/

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	Logger log = Logger.getLogger("LogoutServlet");
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.invalidate();
		log.warning("Invalidated session");
		response.sendRedirect("/user-login");
	}

}
