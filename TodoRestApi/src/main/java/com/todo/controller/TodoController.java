package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entities.TodoEntity;
import com.todo.service.TodoService;

@RestController
public class TodoController {
	@Autowired
	TodoService todoService;
	
	@GetMapping("/todo")
	public ResponseEntity<List<TodoEntity>> showTodos() {
		List<TodoEntity> todoList = todoService.loadTodos();
		if(todoList.size()<=0) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(todoList);
	}
	
	@GetMapping("/todo/{id}")
	public ResponseEntity<TodoEntity> showTodo(@PathVariable Long id) {
		TodoEntity todo = todoService.loadTodo(id);
		
		if(todo.getId() == null) {
			System.out.println(todo);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(todo);
	}
	
	@PostMapping("/todo")
	public ResponseEntity<String> saveTodo(@RequestBody TodoEntity todoEntity) {
		
		Long id = todoService.saveTodo(todoEntity);
		
		return new ResponseEntity<String>("Todo with "+id+" successfully created.",HttpStatus.CREATED) ;
	}
	
	@PutMapping("/todo/{id}")
	public ResponseEntity<String> updateTodo(@RequestBody TodoEntity todoEntity
			,@PathVariable Long id) {
		
		todoService.updateTodo(todoEntity,id);
		return new ResponseEntity<String>("Todo with "+id+" successfully updated.", HttpStatus.OK);
		
	}
	
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
		
		todoService.deleteTodo(id);
		return new ResponseEntity<String>("Todo with "+id+" successfully Deleted.", HttpStatus.NO_CONTENT);
	}
	
	
	
}
