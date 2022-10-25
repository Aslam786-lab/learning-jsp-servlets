package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.dao.TodoDao;
import com.todo.entities.TodoEntity;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	TodoDao todoDao;
	
	@Override
	public List<TodoEntity> loadTodos() {
		List<TodoEntity> todoList = todoDao.loadTodos();
		System.out.println("Service"+todoList);
		return todoList;
	}
	
	@Override
	public TodoEntity loadTodo(Long id) {
		TodoEntity todo =todoDao.loadTodo(id);
		return todo;
	}

	
	@Override
	public Long saveTodo(TodoEntity todoEntity) {
		
		Long id =todoDao.saveTodo(todoEntity);
		return id;
		
	}


	@Override
	public void updateTodo(TodoEntity todoEntity, Long id) {
		todoDao.updateTodo(todoEntity, id);
	}
	
	@Override
	public void deleteTodo(Long id) {
		todoDao.deleteTodo(id);
	}





	

}
