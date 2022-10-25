package com.todo.dao;

import java.util.List;

import com.todo.entities.TodoEntity;

public interface TodoDao {

	List<TodoEntity> loadTodos();
	
	TodoEntity loadTodo(Long id);
	
	Long saveTodo(TodoEntity todoEntity);

	void updateTodo(TodoEntity todoEntity, Long id);

	void deleteTodo(Long id);


}
