package com.auth.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */

public class AuthenticationFilter implements Filter {

	Logger log = Logger.getLogger("AuthenticationFilter");
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession(false);
		String loginURL = "/user-login";
		log.warning("Authenticating session in AuthenticationFilter");
	    boolean loggedIn = session != null && session.getAttribute("email") != null;
	    System.out.println("AuthenticationFilterServlet");
	    System.out.println(loggedIn);
	    if (loggedIn ) {
	        chain.doFilter(request, response);
	    } else {
	        res.sendRedirect(loginURL);
	    }
		
	}

	
	
	
	
	
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
