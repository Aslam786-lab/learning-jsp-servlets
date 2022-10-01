package com.servlet.creation.type;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.*;

public class ServletInterface implements Servlet {
	ServletConfig conf;
	
	//life cycle methods
	@Override
	public void init(ServletConfig conf) throws ServletException {
		this.conf = conf;
		System.out.println("creating object...");
		
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Servicing....");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1>This is the service method</h1>");
		out.println("<h1>todays date is "+new Date().toString()+"</h1>");
	}

	@Override
	public void destroy() {
		
		System.out.println("going to destroy service object");
	}
	
	
	
	//non life cycle methods
	@Override
	public ServletConfig getServletConfig() {
		
		return this.conf;
	}
	@Override
	public String getServletInfo() {
		
		return "servlet is created by ak";
	}
}
