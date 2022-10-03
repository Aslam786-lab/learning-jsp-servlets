package com.hiddenform.field;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hiddens1")
public class Servlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		
		out.println("<h1>hello, "+name+" welcome to website</h1>");
//		out.println("<h1><a href='hiddens2'>go to servlet2</a></h1>");
		
		out.println(""
				+ "<form action='hiddens2'>"
				+ "<input type='hidden' name='user_name' value='"+name+"' />"
				+ "<button>go to servlet2</button>"
				+ ""
				+ "</form>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
