package com.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

	@SuppressWarnings("unused")
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;

		
		String username = req.getParameter("user_name");
		String password = req.getParameter("user_password");
		
		HttpSession session = request.getSession();
		session.setAttribute("name", username);
		
		if(username != null && username != "") {
			if(username.equals("admin") && password.equals("admin")) {
				
				chain.doFilter(req, res);
				
			}
			else {
				request.setAttribute("message", "Invalid Account");
				request.getRequestDispatcher("/").forward(request, response);
				
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
			
	}

}
