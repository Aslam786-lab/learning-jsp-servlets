package com.todo.entities;

public class TodoEntity {
	Long id;
	String todo;
	String description;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "TodoEntity [id=" + id + ", todo=" + todo + ", description=" + description + "]";
	}
		
	
}
