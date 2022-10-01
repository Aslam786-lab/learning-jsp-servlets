package com.servlet.creation.type;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletDemo extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("this is genric servlet");
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("This is generic servlet");
		
	}

}
