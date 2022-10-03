package com.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//fetch cookies
		Cookie[] cookies = request.getCookies();
		
		boolean f = false;
		String name = "";
		
		if(cookies == null) {
			out.println("<h1>Your new user go to home page and submit your name</h1>");
			return;
		}else {
			for(Cookie c : cookies) {
				String tname=c.getName();
				if(tname.equals("user_name")) {
					f = true;
					name = c.getValue();
				}
				
			}
		}
		
		//======================================
		if(f) {
			out.println("<h1>hello, "+name+" welcome back to website</h1>");
			out.println("<h1>Thank You</h1>");
		}else {
			out.println("<h1>Your new user go to home page and submit your name</h1>");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
