package com.todo.service;

import java.util.List;

import com.todo.entities.TodoEntity;


public interface TodoService {

	List<TodoEntity> loadTodos();
	
	TodoEntity loadTodo(Long id);
	
	Long saveTodo(TodoEntity todoEntity);

	void updateTodo(TodoEntity todoEntity, Long id);

	void deleteTodo(Long id);


	

}
