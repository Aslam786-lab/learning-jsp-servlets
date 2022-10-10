package com.auth.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		
		Entity entity = new Entity("User");
		
		
		
		String name = request.getParameter("user_name");
		String city = request.getParameter("user_city");
		String age = request.getParameter("user_age");
		String gender = request.getParameter("user_gender");
		String password = request.getParameter("user_password");
		
		entity.setProperty("name", name);
		entity.setProperty("city", city);
		entity.setProperty("age", age);
		entity.setProperty("gender", gender);
		entity.setProperty("password", password);
		
		
		datastore.put(entity);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("registered", "successfully registered please login");
		response.sendRedirect(request.getContextPath()+"login.jsp");

		
		
	}
	
	
	
	
	
	public void checkUserId(String uuid,DatastoreService datastore) {
		Query query = new Query("User")
				.setFilter(new FilterPredicate("Key", FilterOperator.EQUAL,uuid ));
		
		//storing the query result in list 
		List<Entity> result=datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		System.out.println(query);	
		System.out.println(result);
	}

}
