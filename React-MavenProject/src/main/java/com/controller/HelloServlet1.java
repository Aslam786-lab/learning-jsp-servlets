package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet1
 */
public class HelloServlet1 extends HttpServlet {
	
	
	protected void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
	}

}
