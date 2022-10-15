package com.auth.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Todo {
	
	@Id Long id;
	@Index String todo;
	
	
	
	public Todo(String todo) {
	
	this.todo = todo;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", todo=" + todo + "]";
	}
	
	
	
}
