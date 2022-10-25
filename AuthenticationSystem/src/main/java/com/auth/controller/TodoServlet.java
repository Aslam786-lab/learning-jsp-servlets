package com.auth.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth.dao.TodoDao;

@WebServlet("/todo")
public class TodoServlet extends HttpServlet {
	
	TodoDao dao = new TodoDao();
	Logger log = Logger.getLogger("Todoservlet");
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		switch (action) {
		case "add":
			addTodo(request, response);
			break;

		default:
			log.severe("Not working");
			break;
		}
		
	}


	private void addTodo(HttpServletRequest request, HttpServletResponse response) {
		String todo = request.getParameter("todo_add");
		System.out.println(todo);
		log.severe("working--------------");
		dao.addTodo(todo);
	}


	

}
