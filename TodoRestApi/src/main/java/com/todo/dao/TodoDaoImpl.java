package com.todo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.todo.entities.TodoEntity;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Repository
public class TodoDaoImpl implements TodoDao {

	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	Query query = new Query("TodoEntity");

	@Override
	public List<TodoEntity> loadTodos() {
		List<TodoEntity> todoList = new ArrayList<TodoEntity>();

		List<Entity> result = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		result.forEach((todoItem) -> {
			TodoEntity todo = new TodoEntity();
			todo.setTodo(todoItem.getProperty("todo").toString());
			todo.setDescription(todoItem.getProperty("description").toString());

			todo.setId(todoItem.getKey().getId());

			todoList.add(todo);

		});

		return todoList;
	}
	
	@Override
	public TodoEntity loadTodo(Long id) {
		TodoEntity todo = new TodoEntity();
		Key userKey = KeyFactory.createKey("TodoEntity", id);
		try {
			Entity responseEntity = datastore.get(userKey);
			todo.setId(id);
			todo.setTodo(responseEntity.getProperty("todo").toString());
			todo.setDescription(responseEntity.getProperty("description").toString());
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return todo;
	}

	@Override
	public Long saveTodo(TodoEntity todoEntity) {

		Entity entity = new Entity("TodoEntity");

		entity.setProperty("todo", todoEntity.getTodo());
		entity.setProperty("description", todoEntity.getDescription());
		Key key=datastore.put(entity);
		
		return key.getId();

	}

	@Override
	public void updateTodo(TodoEntity todoEntity, Long id) {
		Entity entity = new Entity("TodoEntity", id);

		entity.setProperty("todo", todoEntity.getTodo());
		entity.setProperty("description", todoEntity.getDescription());

		datastore.put(entity);
		
	}

	@Override
	public void deleteTodo(Long id) {

		Key entityKey = KeyFactory.createKey("TodoEntity", id);

		datastore.delete(entityKey);
	}

	

}
