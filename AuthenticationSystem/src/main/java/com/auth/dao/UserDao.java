package com.auth.dao;

import java.util.ArrayList;
import java.util.List;

import com.auth.entities.User;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

public class UserDao {
	
	public User userNamePasswordAuth(String name, String password) {
		User user = new User();
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("User")
				.setFilter(new FilterPredicate("name", FilterOperator.EQUAL, name));
		
		//storing the query result in list 
		List<Entity> result=datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		
		
		
		//user exists or not 
		if(result.size()>0) {
			result.forEach((e)->{
				
				//password associated with user exist or not
				if(e.getProperty("password").equals(password) ) {
					
					
					user.setName((String)e.getProperty("name"));
					user.setCity((String)e.getProperty("city"));
					user.setAge(Integer.parseInt((String) e.getProperty("age")));
					user.setGender((String)e.getProperty("gender"));
					user.setPassword((String)e.getProperty("password"));
//					
					
					
				}
			});
			
		}
		
		//password associated with user exist or not
		return user;

	}
}
