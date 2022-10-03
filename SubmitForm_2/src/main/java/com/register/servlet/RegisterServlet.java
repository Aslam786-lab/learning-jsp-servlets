package com.register.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<h1>Thank you for registration!");
		
		String name = req.getParameter("user_name");
		String password = req.getParameter("user_password");
		String email = req.getParameter("user_email");
		String gender = req.getParameter("user_gender");
		String course = req.getParameter("user_course");
		String condition = req.getParameter("condition");
		
		if (condition != null) {
			out.println("<h2> Name     :"+name+"</h2>");
			out.println("<h2> Email     :"+email+"</h2>");
			out.println("<h2> Gender     :"+gender+"</h2>");
			out.println("<h2> Course     :"+course+"</h2>");
			
			//data is saved to db
			RequestDispatcher rd = req.getRequestDispatcher("success");
			rd.forward(req, res);
			
		}else {
			
			out.println("<h2>Please accept the terms and conditions</h2>");
			//Include output of index.html
			
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			rd.include(req, res);
		}
	}
}
