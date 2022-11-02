package com.auth.dao;
import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.logging.Logger;

import com.auth.entities.Todo;
import com.auth.entities.User;
public class TodoDao {
	
	public void addTodo(String textTodo) {
		
	
		Todo todo = new Todo(textTodo);
		
		ofy().save().entity(todo).now();
		
		Logger log = Logger.getLogger("TodoDao");
		log.severe("Todo is added");
	}
	
}
